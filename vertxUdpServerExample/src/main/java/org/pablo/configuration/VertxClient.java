package org.pablo.configuration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;

public class VertxClient extends AbstractVerticle{

	@Override
	public void start() throws Exception {
		DatagramSocket  ds = vertx.createDatagramSocket(new DatagramSocketOptions());
		ds.send("hello", 8080, "10.0.0.66", ar -> {});
		System.out.println("Done!.");
	}

}
