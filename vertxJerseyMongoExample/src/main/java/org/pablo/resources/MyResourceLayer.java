package org.pablo.resources;

import io.vertx.core.Vertx;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pablo.assemblers.PersonAssembler;
import org.pablo.domain.Person;
import org.pablo.dto.PersonDto;
import org.pablo.service.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("resource")
public class MyResourceLayer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	private PersonServiceImpl personServiceImpl;
	
	@Inject
	private PersonAssembler personAssembler;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPerson(@Suspended AsyncResponse asyncResponse,  @Context Vertx vertx, @Valid PersonDto person) throws IOException {
		LOG.info("Resource");
		Person p = personServiceImpl.singUp(personAssembler.apply(person));
		 asyncResponse.resume(personAssembler.applyReverseType(p));		 
	}

}

