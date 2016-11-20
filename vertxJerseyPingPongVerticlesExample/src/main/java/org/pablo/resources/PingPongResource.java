package org.pablo.resources;

import io.vertx.core.Vertx;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pablo.codec.PingPongSerializer;
import org.pablo.dto.PingPongDto;
import org.pablo.eventBusBridge.EventBusBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("ping")
public class PingPongResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String REQUEST_ADDRESS = "ping-pong-request";
	
	@Inject
	private PingPongSerializer pingPongSerializer;
	
	@GET
	@Path("/pong")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getCurrentTime(@Suspended AsyncResponse asyncResponse, @Context Vertx vertx) throws IOException {
		
		 CompletableFuture<PingPongDto> callPingServicePromise = new CompletableFuture<PingPongDto>();
	     EventBusBridge.INSTANCE.getEventBus().send(REQUEST_ADDRESS, pingPongSerializer.toByteArray(new PingPongDto()), reply -> {
	    	 callPingServicePromise.complete(pingPongSerializer.fromByteArray((byte[])reply.result().body()));	           
	     });
	     
	     callPingServicePromise.thenAccept(pingPongResult -> asyncResponse.resume(pingPongResult));
	      
	}

	public PingPongSerializer getPingPongSerializer() {
		return pingPongSerializer;
	}

	public void setPingPongSerializer(PingPongSerializer pingPongSerializer) {
		this.pingPongSerializer = pingPongSerializer;
	}
	
}

