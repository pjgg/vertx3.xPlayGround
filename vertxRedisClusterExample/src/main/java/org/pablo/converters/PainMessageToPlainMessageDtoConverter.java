package org.pablo.converters;


import org.pablo.dto.PlainMessageDto;
import org.pablo.model.PlainMessage;

public class PainMessageToPlainMessageDtoConverter implements Converter<PlainMessage, PlainMessageDto>{

    @Override
    public PlainMessageDto apply(PlainMessage plainMessage){
        PlainMessageDto plainMessageDto = new PlainMessageDto();
        plainMessageDto.setMsg(plainMessage.getMsg());
        plainMessageDto.setUpdatedAt(plainMessage.getUpdatedAt());
        plainMessageDto.setCreatedAt(plainMessage.getCreatedAt());

        return plainMessageDto;

    }
}
