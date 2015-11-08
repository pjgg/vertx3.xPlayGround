package org.pablo.codec;

public interface ByteArraySerializer<T> {

	byte[] toByteArray(T object) throws SerializationException;

	T fromByteArray(byte[] bytes) throws SerializationException;

}
