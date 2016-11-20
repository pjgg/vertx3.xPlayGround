package org.pablo.configuration;

import javax.inject.Inject;

import com.englishtown.vertx.jersey.promises.WhenJerseyServer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class VerticleConf extends AbstractVerticle {
	
	private final WhenJerseyServer jerseyServer;

	@Inject
    public VerticleConf(WhenJerseyServer jerseyServer) {
        this.jerseyServer = jerseyServer;
    }
	
	@Override
	public void start(Future<Void> startedResult) {
		
        jerseyServer.createServer()
                .then(server -> {
                    startedResult.complete();
                    return null;
                })
                .otherwise(t -> {
                    startedResult.fail(t);
                    return null;
                });
		
	}
	
}
