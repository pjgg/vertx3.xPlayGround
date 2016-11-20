package org.pablo.redisConnector;


import com.lambdaworks.redis.pubsub.api.rx.ChannelMessage;
import org.pablo.model.PlainMessage;
import rx.Observable;

public interface RedisConnector {

    void test();

    void pushToRedis(String channel, PlainMessage plainMsg);

    Observable<ChannelMessage<String, PlainMessage>> subcribeToChannel(String channel);

}
