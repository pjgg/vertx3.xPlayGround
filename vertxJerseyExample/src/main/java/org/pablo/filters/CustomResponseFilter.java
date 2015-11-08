package org.pablo.filters;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomResponseFilter implements ContainerResponseFilter {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static final String HEADER_X_POWERED_BY = "X-Powered-By";
    public static final String HEADER_X_POWERED_BY_VALUE = "Jersey :-)";
    public static final String HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String HEADER_ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
    public static final String HEADER_ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String HEADER_ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS";
    
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		LOG.info("Log 2");
		responseContext.getHeaders().add(HEADER_X_POWERED_BY, HEADER_X_POWERED_BY_VALUE);
		responseContext.getHeaders().add(HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, HEADER_ACCESS_CONTROL_ALLOW_ORIGIN_VALUE);
		responseContext.getHeaders().add(HEADER_ACCESS_CONTROL_ALLOW_METHODS, HEADER_ACCESS_CONTROL_ALLOW_METHODS_VALUE);
	}

}
