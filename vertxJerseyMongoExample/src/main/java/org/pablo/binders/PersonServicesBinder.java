package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.repository.PersonRepositoryImpl;
import org.pablo.service.PersonServiceImpl;

public class PersonServicesBinder extends AbstractBinder{
	@Override
    protected void configure() {
		bind(PersonServiceImpl.class).to(PersonServiceImpl.class).in(Singleton.class);
		bind(PersonRepositoryImpl.class).to(PersonRepositoryImpl.class).in(Singleton.class);
	}
}
