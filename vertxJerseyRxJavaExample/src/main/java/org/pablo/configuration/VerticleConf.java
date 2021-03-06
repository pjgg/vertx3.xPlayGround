package org.pablo.configuration;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.englishtown.vertx.jersey.promises.WhenJerseyServer;

public class VerticleConf extends io.vertx.rxjava.core.AbstractVerticle {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
