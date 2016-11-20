package org.pablo.configuration;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;

import org.pablo.eventBusBridge.EventBusBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.englishtown.vertx.jersey.promises.WhenJerseyServer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;

public class VerticleConf extends AbstractVerticle {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final WhenJerseyServer jerseyServer;

	@Inject
    public VerticleConf(WhenJerseyServer jerseyServer) {
        this.jerseyServer = jerseyServer;
    }
	
	@Override
	public void start(Future<Void> startedResult) {
		
		LOG.info("Main Verticle start!");
		
		EventBusBridge.INSTANCE.setEventBus(vertx.eventBus());
		
		//Resource layer
		
        jerseyServer.createServer()
                .then(server -> {
                    startedResult.complete();
                    return null;
                })
                .otherwise(t -> {
                    startedResult.fail(t);
                    return null;
                });
        
        
        //Service layer
        
        DeploymentOptions options = new DeploymentOptions();
		options.setConfig(vertx.getOrCreateContext().config());
		options.setHa(true);
		
        vertx.deployVerticle("java-hk2:org.pablo.verticles.PingVerticle", options);
        vertx.deployVerticle("java-hk2:org.pablo.verticles.PongVerticle", options);      
  	}	
	

//	private JsonObject getJerseyConfig(){
//		return vertx.getOrCreateContext().config().getJsonObject("server");
//	}
}
