package org.pablo.binders;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.repository.PersonRepository;
import org.pablo.repository.PersonRepositoryImpl;
import org.pablo.service.PersonService;
import org.pablo.service.PersonServiceImpl;

public class PersonServicesBinder extends AbstractBinder{
	@Override
    protected void configure() {
		bind(PersonServiceImpl.class).to(PersonService.class).in(Singleton.class);
		bind(PersonRepositoryImpl.class).to(PersonRepository.class).in(Singleton.class);
	}
}
