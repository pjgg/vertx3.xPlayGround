package org.pablo.exceptionMapper;

import java.lang.invoke.MethodHandles;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CustomExceptionMapper extends AbstractExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public CustomExceptionMapper(){
		initializeFromProperties();
		LOG.debug("ExceptionMapper ... Initialized.");
	}

//	@Override
//	public Response toResponse(Exception exception) {
//		DataException httpDataException = httpDataException(exception, httpCodes);
//		return buildErrorResponse(exception.getMessage(), exception.getClass().getSimpleName(), httpDataException, null);
//	}

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		DataException httpDataException = httpDataException(exception, httpCodes);
		return buildErrorResponse(exception.getMessage(), exception.getClass().getSimpleName(), httpDataException, null);
	}
	
}

