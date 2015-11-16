package org.pablo.utils;

import io.vertx.core.Vertx;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum VertxBridge {
	INSTANCE(null);
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private Vertx vertx;
	

    private VertxBridge(Vertx v) {
        this.vertx = v;
    }

	public Vertx getVertx() {
		if(null == vertx){
			LOG.error("EventBusBridge must be initialized by setEventBus method. For example in your main verticle write down something like,  EventBusBridge.INSTANCE.setEventBus(vertx.eventBus());");
		}
		return vertx;
	}

	public void setVertx(Vertx v) {
		this.vertx = v;
	}
    
}
