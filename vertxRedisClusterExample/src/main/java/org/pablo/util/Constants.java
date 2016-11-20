package org.pablo.util;


import io.vertx.core.Context;


public final class Constants {

    private static Constants instance = null;

    private final static String REDIS_KEY_NAME = "redis";
    private final static String REDIS_HOST_KEY_NAME = "host";
    private final static String REDIS_PORT_KEY_NAME = "port";

    public static String REDIS_HOST;
    public static Integer REDIS_PORT;

    protected Constants(Context context){
        REDIS_HOST = context.config().getJsonObject(REDIS_KEY_NAME).getString(REDIS_HOST_KEY_NAME);
        REDIS_PORT = context.config().getJsonObject(REDIS_KEY_NAME).getInteger(REDIS_PORT_KEY_NAME);
    }

    public static synchronized Constants loadValues(Context context){
        if (instance == null) {
            instance = new Constants(context);
        }
        return instance;
    }

}
