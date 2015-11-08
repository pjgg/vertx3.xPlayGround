package org.pablo.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.pablo.eventBusBridge.EventBusBridge;
import org.pablo.service.PingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingVerticle extends AbstractVerticle {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String PING_VERTICLE_ADDRESS = "ping-pong-request";
	
	@Inject
	private PingService pingService;
	
	@Override
    public void start(Future<Void> startedResult) throws Exception {
		EventBusBridge.INSTANCE.getEventBus().localConsumer(PING_VERTICLE_ADDRESS,  message -> {
			pingService.doHandler(message);	
         });	 
	}

	public PingService getPingService() {
		return pingService;
	}

	public void setPingService(PingService pingService) {
		this.pingService = pingService;
	}

}
