package org.pablo.configuration;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import org.pablo.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GuiceVerticleConf extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void start(Future<Void> startedResult) {
        LOG.info("Main Verticle start!");
        Constants.loadValues(context);
        DeploymentOptions deploymentOptions = new DeploymentOptions();
        JsonObject jsonConfig = context.config();
        jsonConfig.put("guice_binder","org.pablo.configuration.CustomBinder");
        deploymentOptions.setConfig(jsonConfig);
        vertx.deployVerticle("java-guice:com.englishtown.vertx.jersey.JerseyVerticle", deploymentOptions);
    }

}

