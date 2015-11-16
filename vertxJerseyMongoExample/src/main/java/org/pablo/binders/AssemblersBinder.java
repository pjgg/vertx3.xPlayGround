package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.assemblers.PersonAssembler;

public class AssemblersBinder extends AbstractBinder{
	@Override
    protected void configure() {
		bind(PersonAssembler.class).to(PersonAssembler.class).in(Singleton.class);
	}

}
