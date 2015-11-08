package org.pablo.configuration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloWorldInit extends AbstractVerticle {
	@Override
	public void start(Future<Void> fut) {
		vertx.createHttpServer()
				.requestHandler(
						r -> {
							r.response().end("<h1>Hello from my first Vert.x 3 application</h1>");
						})
				.listen(getServerPort(),
						result -> {
							if (result.succeeded()) {
								fut.complete();
							} else {
								fut.fail(result.cause());
							}
						});
	}

	private int getServerPort(){
		Integer port = 3849;
		if(this.config().containsKey("rest")){
			port = this.config().getJsonObject("rest").getInteger("port");
		}
		
		return port;
	}
}
