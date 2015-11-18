package org.pablo.resources;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.pablo.binders.CustomSimpleDateFormat;
import org.pablo.dto.Person;
import org.pablo.dto.TimestampDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.englishtown.promises.Deferred;
import com.englishtown.promises.When;

@Path("resource")
public class MyResourceLayer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	 
	@Inject
	private When when;
	
	@Inject
	private CustomSimpleDateFormat simpleDateFormat;

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getString(@Suspended AsyncResponse asyncResponse) throws IOException {

        Deferred<String> d = when.defer();

        d.getPromise()
                .then(str -> {
                    asyncResponse.resume(str);
                    return null;
                })
                .otherwise(t -> {
                    asyncResponse.resume(new WebApplicationException(t));
                    return null;
                });

        d.resolve("when.java!");
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPerson(@Suspended AsyncResponse asyncResponse, @Valid Person person) throws IOException {
		 Deferred<Person> d = when.defer();

	        d.getPromise()
	                .then(p -> {
	                    asyncResponse.resume(p);
	                    return null;
	                })
	                .otherwise(t -> {
	                    asyncResponse.resume(new WebApplicationException(t));
	                   return null;
	                });
            
	        person.setFirstname(person.getFirstname() + " New Name");
	        person.setId(UUID.randomUUID().toString());
	        d.resolve(person);
	}

	
	@GET
	@Path("/currentTime")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getCurrentTime(@Suspended AsyncResponse asyncResponse) throws IOException {
		 Deferred<TimestampDTO> d = when.defer();
			
	        d.getPromise()
	                .then(date -> {
	                    asyncResponse.resume(date);
	                    return null;
	                })
	                .otherwise(t -> {
	                    asyncResponse.resume(new WebApplicationException(t));
	                    return null;
	                });
            
	        Date currentTime = new Date();
			TimestampDTO timestampDTO = new TimestampDTO();
			timestampDTO.setTimeInMillisFrom1970(currentTime.getTime());
			timestampDTO.setTimeInISO8601(simpleDateFormat.format(currentTime));
			
	        d.resolve(timestampDTO);
	}
	
	public When getWhen() {
		return when;
	}

	public void setWhen(When when) {
		this.when = when;
	}
	
}

