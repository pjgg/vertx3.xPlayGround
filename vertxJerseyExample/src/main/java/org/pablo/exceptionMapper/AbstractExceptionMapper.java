package org.pablo.exceptionMapper;

import java.lang.invoke.MethodHandles;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AbstractExceptionMapper {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	protected Map<String, DataException> httpCodes = null;

	protected ErrorResponse buildErrorBean(Status status, Integer code, String className, String description, String msg) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(status.getStatusCode());
		error.setStatusReason(status.getReasonPhrase());
		error.setCode(code);
		error.setException(className);
		error.setDescription(description);
		error.setMessage(msg);
		return error;
	}
	
	protected void initializeFromProperties() {

		httpCodes = new HashMap<String, DataException>();
		Enumeration<String> allErrorsKeys = RestErrors.getKeys();
		while (allErrorsKeys.hasMoreElements()) {
			try {
				String exceptionName = allErrorsKeys.nextElement();
				String string = RestErrors.getString(exceptionName);
				String restErrorLineValue[] = string.split(",");
				int code = Integer.parseInt(restErrorLineValue[0]);
				String status = restErrorLineValue[1];
				String description = restErrorLineValue[2];
				LOG.debug(exceptionName + ";" + string + ";" + status + ";" + description);
				httpCodes.put(exceptionName, new DataException(code, Status.valueOf(status), description));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	protected DataException httpDataException(Exception exception, Map<String, DataException> httpCodes) {
		String className = exception.getClass().getName();
		DataException dataException = httpCodes.get(className);

		if (dataException == null) {
			httpCodes.put(className, new DataException(httpCodes.keySet().size() + 1, Status.INTERNAL_SERVER_ERROR, ""));
			dataException = httpCodes.get(className);
			LOG.error("Application Error", exception);
		} else {		  
			LOG.warn("User Error: {}, {}, {}", dataException.getDescription(), exception.getMessage(), exception.getStackTrace());
		}

		return dataException;
	}
	
	protected DataException httpConstraintException(ConstraintViolationException exception, Map<String, DataException> httpCodes) {
		String className = exception.getClass().getName();
		DataException dataException = httpCodes.get(className);

		if (dataException == null) {
			httpCodes.put(className, new DataException(httpCodes.keySet().size() + 1, Status.INTERNAL_SERVER_ERROR, ""));
			dataException = httpCodes.get(className);
			LOG.error("Application Error", exception);
			
		} else {		  
			Set<ConstraintViolation<?>> constraints = exception.getConstraintViolations();
			String msg = "";
			for(ConstraintViolation constraint : constraints){
				msg = constraint.getMessage() + ". ";
			}
			
			LOG.warn("User Error: {}, {}, {}", dataException.getDescription(), exception.getMessage(), msg);
		}

		return dataException;
	}
	
	protected Response buildErrorResponse(String exceptionMessage, String exceptionClassSimpleName, DataException httpDataException, Status status) {
		if (null == status)
			status = httpDataException.getStatus();
		ErrorResponse error = buildErrorBean(status, httpDataException.getCode(), exceptionClassSimpleName, httpDataException.getDescription(),
				exceptionMessage);
		return Response.status(status.getStatusCode()).entity(error).build();
	}
}