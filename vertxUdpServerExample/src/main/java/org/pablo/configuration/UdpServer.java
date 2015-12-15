package org.pablo.configuration;

import java.lang.invoke.MethodHandles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class UdpServer extends AbstractVerticle {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void start() {
		LOG.info("Port: " + getJerseyConfig().getInteger("port") + " host: "+ getJerseyConfig().getString("host"));
		DatagramSocket socket = vertx.createDatagramSocket(new DatagramSocketOptions());
		socket.listen(getJerseyConfig().getInteger("port"), getJerseyConfig().getString("host"), asyncResult -> {
		  if (asyncResult.succeeded()) {
		    socket.handler(packet -> {
		    	LOG.info(packet.data());
		    });
		  } else {
		    System.out.println("Listen failed" + asyncResult.cause());
		  }
		});
	}
	
	private JsonObject getJerseyConfig(){
		return vertx.getOrCreateContext().config().getJsonObject("server");
	}
}
