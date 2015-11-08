package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class SimpleDateFormatBinder extends AbstractBinder{

	@Override
	protected void configure() {
		//to should be an interface.
		// Configure bindings
        bind(CustomSimpleDateFormat.class).to(CustomSimpleDateFormat.class).in(Singleton.class);
	}

}
