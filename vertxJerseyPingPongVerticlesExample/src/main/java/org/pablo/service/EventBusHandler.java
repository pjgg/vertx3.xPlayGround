package org.pablo.service;

import io.vertx.core.eventbus.Message;

public interface EventBusHandler {
	
	void doHandler(Message<Object> message);

}
