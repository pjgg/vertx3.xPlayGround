package org.pablo.codec;

import org.pablo.codec.PingPongPayload.PingPongMessage;
import org.pablo.dto.PingPongDto;

import com.google.protobuf.InvalidProtocolBufferException;

public class PingPongSerializer implements ByteArraySerializer<PingPongDto>{
	
	@Override
	public byte[] toByteArray(PingPongDto pingPongDto) throws SerializationException {
		PingPongPayload.PingPongMessage.Builder builder = PingPongPayload.PingPongMessage.newBuilder()
				.setPing(pingPongDto.getPing()).setPong(pingPongDto.getPong());
		
		return builder.build().toByteArray();
	}

	@Override
	public PingPongDto fromByteArray(byte[] bytes) throws SerializationException {
		try {
			PingPongMessage pingPongMessage = PingPongPayload.PingPongMessage.parseFrom(bytes);
			return new PingPongDto(pingPongMessage.getPing(), pingPongMessage.getPong());
		} catch (InvalidProtocolBufferException e) {
			throw new SerializationException(e);
		}	
	}
}
