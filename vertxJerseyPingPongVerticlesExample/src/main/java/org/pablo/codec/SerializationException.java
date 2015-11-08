package org.pablo.codec;

public class SerializationException extends RuntimeException {

	private static final long serialVersionUID = -2345224227493539817L;

	public SerializationException(String message) {
		super(message);

	}

	public SerializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public SerializationException(Throwable cause) {
		super(cause);
	}

}
