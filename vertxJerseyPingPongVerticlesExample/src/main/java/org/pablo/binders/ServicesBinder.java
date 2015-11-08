package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.service.PingService;
import org.pablo.service.PongService;

public class ServicesBinder extends AbstractBinder{
	@Override
    protected void configure() {
		bind(PingService.class).to(PingService.class).in(Singleton.class);
		bind(PongService.class).to(PongService.class).in(Singleton.class);
	}
}
