package org.pablo.resources;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pablo.binders.CustomSimpleDateFormat;
import org.pablo.dto.Status;
import org.pablo.manager.ShrodingersCatImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("resource")
public class MyResourceLayer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	private CustomSimpleDateFormat simpleDateFormat;
	
	@Inject
	private ShrodingersCatImpl shrodingersCat;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setStatus(@Suspended AsyncResponse asyncResponse, @Valid Status catStatus) throws IOException {
		shrodingersCat.setCatSatus(catStatus.getValue());
		asyncResponse.resume(Response.noContent().build());
	}

	
	@GET
	@Path("/push")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void isAlive(@Suspended AsyncResponse asyncResponse) throws IOException {
		shrodingersCat.isAlivePush().subscribe(statusEvent -> asyncResponse.resume(Response.accepted(new Status(statusEvent.booleanValue())).build()));
	}
	
	
	@GET
	@Path("/pull")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void isAliveTwo(@Suspended AsyncResponse asyncResponse) throws IOException {
		shrodingersCat.isAlivePull().thenAccept(statusEvent -> asyncResponse.resume(Response.accepted(new Status(statusEvent.booleanValue())).build()));
	}
}

