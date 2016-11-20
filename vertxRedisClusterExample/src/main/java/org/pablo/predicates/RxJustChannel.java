package org.pablo.predicates;


import com.lambdaworks.redis.pubsub.api.rx.ChannelMessage;
import rx.functions.Func2;

public class RxJustChannel implements Func2<ChannelMessage<String, String>, String, Boolean> {

    @Override
    public Boolean call(ChannelMessage<String, String> stringStringChannelMessage, String expectedChannel) {
        return stringStringChannelMessage.getChannel().equalsIgnoreCase(expectedChannel);
    }
}
