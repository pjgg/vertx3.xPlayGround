package org.pablo.service;

import io.vertx.core.eventbus.Message;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.pablo.codec.PingPongSerializer;
import org.pablo.dto.PingPongDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PongService implements EventBusHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Inject
	private PingPongSerializer pingPongSerializer;
    
    @Override
	public void doHandler(Message<Object> message) {
    	PingPongDto pingPongDto = pingPongSerializer.fromByteArray((byte[])message.body());
    	pingPongDto.setPong("pong");
    	message.reply(pingPongSerializer.toByteArray(pingPongDto));
	}
	
	
	public PingPongSerializer getPingPongSerializer() {
		return pingPongSerializer;
	}

	public void setPingPongSerializer(PingPongSerializer pingPongSerializer) {
		this.pingPongSerializer = pingPongSerializer;
	}
	
}
