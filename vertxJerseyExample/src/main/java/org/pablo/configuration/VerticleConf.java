package org.pablo.configuration;

import com.englishtown.vertx.jersey.promises.WhenJerseyServer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

public class VerticleConf extends AbstractVerticle {
	
	private final WhenJerseyServer jerseyServer;

	@Inject
    public VerticleConf(WhenJerseyServer jerseyServer) {
        this.jerseyServer = jerseyServer;
    }
	
	@Override
	public void start(Future<Void> startedResult) {
		
        jerseyServer.createServer(getJerseyConfig())
                .then(server -> {
                    startedResult.complete();
                    return null;
                })
                .otherwise(t -> {
                    startedResult.fail(t);
                    return null;
                });
		
	}
	
	private JsonObject getJerseyConfig(){
		return vertx.getOrCreateContext().config().getJsonObject("server");
	}
}
