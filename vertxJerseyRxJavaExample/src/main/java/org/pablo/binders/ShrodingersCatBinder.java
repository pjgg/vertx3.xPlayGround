package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.manager.ShrodingersCatImpl;

public class ShrodingersCatBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(ShrodingersCatImpl.class).to(ShrodingersCatImpl.class).in(Singleton.class);
	}
	
}
