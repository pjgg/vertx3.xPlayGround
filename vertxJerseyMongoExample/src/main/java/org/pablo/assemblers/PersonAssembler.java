package org.pablo.assemblers;

import org.pablo.domain.Person;
import org.pablo.dto.PersonDto;
import org.pablo.utils.SuperAssembler;

public class PersonAssembler extends SuperAssembler<PersonDto, Person> {

	public PersonAssembler() {
		super(PersonDto.class, Person.class);
	}

}
