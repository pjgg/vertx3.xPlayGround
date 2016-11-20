package org.pablo.configuration;

import com.englishtown.vertx.guice.GuiceJerseyBinder;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.codec.Utf8StringCodec;
import com.lambdaworks.redis.pubsub.StatefulRedisPubSubConnection;
import org.pablo.converters.Converter;
import org.pablo.converters.PainMessageToPlainMessageDtoConverter;
import org.pablo.converters.PlainMessageDtoToPainMessageConverter;
import org.pablo.redisConnector.RedisConnector;
import org.pablo.redisConnector.RedisConnectorImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import static org.pablo.util.Constants.REDIS_HOST;
import static org.pablo.util.Constants.REDIS_PORT;

/**˜
 * Custom guice binder
 */
public class CustomBinder extends AbstractModule {

    /**
     * Configures a {@link com.google.inject.Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        install(new GuiceJerseyBinder());

        RedisURI redisUri = RedisURI.Builder.redis(REDIS_HOST).withPort(REDIS_PORT).build();
        bind(RedisClient.class).toProvider(new RedisClientProvider((redisUri))).in(Singleton.class);
        bind(RedisClient.class).annotatedWith(Names.named("RedisClientPubSubProvider")).toProvider(new RedisClientPubSubProvider((redisUri))).in(Singleton.class);
        bind(StatefulRedisConnection.class).toProvider(new StatefulRedisConnectionProvider(redisUri)).in(Singleton.class);
        bind(StatefulRedisPubSubConnection.class).toProvider(new ReactivePubSubRedisConnectionProvider(redisUri)).in(Singleton.class);

        // POJOs
        bind(RedisConnector.class).to(RedisConnectorImpl.class);
        bind(Converter.class).annotatedWith(Names.named("PlainMessageDtoToPainMessageConverter")).to(PlainMessageDtoToPainMessageConverter.class);
        bind(Converter.class).annotatedWith(Names.named("PainMessageToPlainMessageDtoConverter")).to(PainMessageToPlainMessageDtoConverter.class);

    }

    /**
     * Provides a {@link RedisClient} instance.
     */
    public static class RedisClientProvider implements Provider<RedisClient> {

        private RedisURI redisURI;

        public RedisClientProvider(RedisURI redisURI) {
            this.redisURI = redisURI;
        }

        @Override
        public RedisClient get() {

            final RedisClient redisClient = RedisClient.create(redisURI);
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    redisClient.shutdown();
                }
            });

            return redisClient;
        }
    }

    /**
     * Provides a {@link RedisClient} instance.
     */
    public static class RedisClientPubSubProvider implements Provider<RedisClient> {

        private RedisURI redisURI;

        public RedisClientPubSubProvider(RedisURI redisURI) {
            this.redisURI = redisURI;
        }

        @Override
        public RedisClient get() {

            final RedisClient redisClient = RedisClient.create(redisURI);
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    redisClient.shutdown();
                }
            });

            return redisClient;
        }
    }

    /**
     * Provides a {@link StatefulRedisConnection} instance.
     */
    public static class StatefulRedisConnectionProvider implements Provider<StatefulRedisConnection<?, ?>> {

        @Inject
        private RedisClient redisClient;

        private RedisURI redisURI;

        public StatefulRedisConnectionProvider(RedisURI redisURI) {
            this.redisURI = redisURI;
        }

        @Override
        public StatefulRedisConnection<?, ?> get() {
            return redisClient.connect(new Utf8StringCodec(), redisURI);
        }
    }

    /**
     * Provides a {@link StatefulRedisConnection} instance.
     */
    public static class ReactivePubSubRedisConnectionProvider implements Provider<StatefulRedisPubSubConnection<?, ?>> {

        @Inject
        @Named("RedisClientPubSubProvider")
        private RedisClient redisClientPubSub;

        private RedisURI redisURI;

        public ReactivePubSubRedisConnectionProvider(RedisURI redisURI) {
            this.redisURI = redisURI;
        }

        @Override
        public StatefulRedisPubSubConnection<?, ?> get() {

            return redisClientPubSub.connectPubSub(new Utf8StringCodec(), redisURI);
        }
    }
}
