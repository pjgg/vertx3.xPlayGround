package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.codec.PingPongSerializer;

public class CodecBinder extends AbstractBinder{

	@Override
	protected void configure() {
		 bind(PingPongSerializer.class).to(PingPongSerializer.class).in(Singleton.class);
	}

}
