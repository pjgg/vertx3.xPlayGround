package org.pablo.eventBusBridge;

import io.vertx.core.eventbus.EventBus;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EventBusBridge {
	INSTANCE(null);
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private EventBus eventBus;
	

    private EventBusBridge(EventBus eb) {
        this.eventBus = eb;
    }

	public EventBus getEventBus() {
		if(null == eventBus){
			LOG.error("EventBusBridge must be initialized by setEventBus method. For example in your main verticle write down something like,  EventBusBridge.INSTANCE.setEventBus(vertx.eventBus());");
		}
		return eventBus;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}
    
}
