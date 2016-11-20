package org.pablo.converters;


import org.pablo.dto.PlainMessageDto;
import org.pablo.model.PlainMessage;

import java.util.Calendar;

public class PlainMessageDtoToPainMessageConverter implements Converter<PlainMessageDto,PlainMessage>{

    @Override
    public PlainMessage apply(PlainMessageDto plainMessageDto){
        PlainMessage plainMessage = new PlainMessage();
        plainMessage.setMsg(plainMessageDto.getMsg());
        plainMessage.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        plainMessage.setUpdatedAt(Calendar.getInstance().getTimeInMillis());

        return plainMessage;
    }

}
