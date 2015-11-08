package org.pablo.binders;

import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.pablo.filters.CustomRequestFilter;
import org.pablo.filters.CustomResponseFilter;

public class FiltersBinder extends AbstractBinder{
	@Override
    protected void configure() {
		bind(CustomRequestFilter.class).to(ContainerRequestFilter.class).ranked(2);
		bind(CustomResponseFilter.class).to(ContainerResponseFilter.class).ranked(1);
	}
}
