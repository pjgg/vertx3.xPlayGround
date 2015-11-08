package org.pablo.filters;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRequestFilter implements ContainerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		LOG.info("Log 1");
	}

	
}
