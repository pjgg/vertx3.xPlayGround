package org.pablo.redisConnector;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.pubsub.StatefulRedisPubSubConnection;
import com.lambdaworks.redis.pubsub.api.rx.ChannelMessage;
import com.lambdaworks.redis.pubsub.api.rx.RedisPubSubReactiveCommands;
import org.pablo.model.PlainMessage;
import org.pablo.predicates.RxJustChannel;
import rx.Observable;

@Singleton
public class RedisConnectorImpl implements RedisConnector {

    private final StatefulRedisPubSubConnection<String, String> connectionPubSub;

    private final StatefulRedisConnection<String, String> connection;

    @Inject
    public RedisConnectorImpl(StatefulRedisPubSubConnection conPubSub, StatefulRedisConnection con) {
        this.connectionPubSub = conPubSub;
        this.connection = con;
    }

    public void test() {
        System.out.println(connection.sync().ping());
    }

    public StatefulRedisConnection getConnection() {
        return connection;
    }

    @Override
    public void pushToRedis(String channel, PlainMessage plainMsg) {
            connection.async().publish(channel, plainMsg.toJson());
    }

    @Override
    public  Observable<ChannelMessage<String, PlainMessage>> subcribeToChannel(String channel) {
        RedisPubSubReactiveCommands<String, String> reactiveCommands = connectionPubSub.reactive();
        reactiveCommands.subscribe(channel).subscribe();

        //filter is not required because you are subcribed to just one channel.
        return reactiveCommands.observeChannels()
                .filter(msg -> new RxJustChannel().call(msg,channel))
                .map(msg ->  new ChannelMessage<> (msg.getChannel(),PlainMessage.fromJson(msg.getMessage()))
                );
    }

}
