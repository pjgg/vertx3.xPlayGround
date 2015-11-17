package org.pablo.configuration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Sender extends AbstractVerticle {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void start() {
		// Publish some news on the feed every second
		vertx.setPeriodic(1000, new Handler<Long>() {
			@Override
			public void handle(Long timerID) {
				LOG.info("info");
				vertx.eventBus().publish("news-feed", "more news!");
			}
		});
	}
}
