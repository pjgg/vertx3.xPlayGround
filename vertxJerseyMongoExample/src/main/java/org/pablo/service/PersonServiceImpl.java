package org.pablo.service;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;
import javax.inject.Named;

import org.pablo.domain.Person;
import org.pablo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PersonServiceImpl implements PersonService{

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Inject
	private PersonRepository personRepository;
	
	@Override
	public Person singUp(Person person) {
		LOG.info("Service");
		return personRepository.savePerson(person);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
