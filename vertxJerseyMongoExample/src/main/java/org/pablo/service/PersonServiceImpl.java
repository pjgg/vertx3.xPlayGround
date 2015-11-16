package org.pablo.service;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.pablo.domain.Person;
import org.pablo.repository.PersonRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonServiceImpl implements PersonService{

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Inject
	private PersonRepositoryImpl personRepositoryImpl;
	
	@Override
	public Person singUp(Person person) {
		LOG.info("Service");
		return personRepositoryImpl.savePerson(person);
	}

	public PersonRepositoryImpl getPersonRepositoryImpl() {
		return personRepositoryImpl;
	}

	public void setPersonRepositoryImpl(PersonRepositoryImpl personRepositoryImpl) {
		this.personRepositoryImpl = personRepositoryImpl;
	}

}
