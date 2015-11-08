package org.pablo.service;

import io.vertx.core.eventbus.Message;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.pablo.codec.PingPongSerializer;
import org.pablo.dto.PingPongDto;
import org.pablo.eventBusBridge.EventBusBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingService implements EventBusHandler{

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static final String PONG_ADDRESS = "pong-address";
	
	@Inject
	private PingPongSerializer pingPongSerializer;
	
	@Override
	public void doHandler(Message<Object> message)  {
		 PingPongDto pingPongDto = createPingValue();
		 makeEventBusRequest(PONG_ADDRESS, pingPongSerializer.toByteArray(pingPongDto)).thenAccept(reply -> {message.reply(reply.body());});
	}
	
	private CompletableFuture<Message<Object>> makeEventBusRequest(String toTopic, byte[] dto){
		 LOG.info("PONG CALL");
		 CompletableFuture<Message<Object>> callPongServicePromise = new CompletableFuture<Message<Object>>();
		 EventBusBridge.INSTANCE.getEventBus().send(toTopic,  dto, reply -> { callPongServicePromise.complete(reply.result()); }); 
         return callPongServicePromise;
	}
	
	private PingPongDto createPingValue(){
		 PingPongDto pingPongDto = new PingPongDto();
		 pingPongDto.setPing("ping");
		 return pingPongDto;
	}
	
	public PingPongSerializer getPingPongSerializer() {
		return pingPongSerializer;
	}

	public void setPingPongSerializer(PingPongSerializer pingPongSerializer) {
		this.pingPongSerializer = pingPongSerializer;
	}

	
}