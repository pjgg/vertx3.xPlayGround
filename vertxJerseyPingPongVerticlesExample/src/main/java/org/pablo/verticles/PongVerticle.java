package org.pablo.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.pablo.eventBusBridge.EventBusBridge;
import org.pablo.service.PongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PongVerticle extends AbstractVerticle {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String PONG_VERTICLE_ADDRESS = "pong-address";
    
    @Inject
    private PongService pongService;

	@Override
    public void start(Future<Void> startedResult) throws Exception {
		EventBusBridge.INSTANCE.getEventBus().localConsumer(PONG_VERTICLE_ADDRESS,  message -> {
			pongService.doHandler(message);	
         });
	}
}
