package org.pablo.resources;

import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ChunkedOutput;
import org.pablo.converters.Converter;
import org.pablo.dto.PlainMessageDto;
import org.pablo.model.PlainMessage;
import org.pablo.redisConnector.RedisConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.invoke.MethodHandles;


@Singleton
@Path("resource")
public class MyResourceLayer {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final RedisConnector redisConnector;

    private final Converter<PlainMessageDto,PlainMessage> plainMessageDtoToPainMessageConverter;

    private final Converter<PlainMessage, PlainMessageDto> painMessageToPlainMessageDtoConverter;

    @Inject
    public MyResourceLayer(RedisConnector redisConnector,
                           @Named("PlainMessageDtoToPainMessageConverter") Converter plainMessageDtoToPainMessageConverter,
                           @Named("PainMessageToPlainMessageDtoConverter") Converter painMessageToPlainMessageDtoConverter) {
        this.redisConnector = redisConnector;
        this.plainMessageDtoToPainMessageConverter = plainMessageDtoToPainMessageConverter;
        this.painMessageToPlainMessageDtoConverter = painMessageToPlainMessageDtoConverter;
    }

    @GET
    @Path("/sse/{channel}")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    @Consumes(SseFeature.SERVER_SENT_EVENTS)
    public void sseMethod(@Suspended final AsyncResponse async,@PathParam("channel") String channel)
            throws IOException, InterruptedException {

        final ChunkedOutput<OutboundEvent> seq = new ChunkedOutput<>(OutboundEvent.class);
        redisConnector.subcribeToChannel(channel)
                .doOnNext(patternMessage -> {
                    PlainMessage plainMsg = patternMessage.getMessage();
                    PlainMessageDto plainMessageDto = painMessageToPlainMessageDtoConverter.apply(plainMsg);
                    writeOutboundEvent(channel, plainMessageDto, seq);
                })
                .subscribe();

        async.resume(seq);
		//seq.close();
    }

    //redis-cli
    //SUBSCRIBE room:test2
    @POST
    @Path("/push/{channel}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void pushMethod(@Suspended final AsyncResponse async, @Valid PlainMessageDto plainMsgDto, @PathParam("channel") String channel) {
        PlainMessage plainMessage = plainMessageDtoToPainMessageConverter.apply(plainMsgDto);
        redisConnector.pushToRedis(channel, plainMessage);
        async.resume(Response.noContent().build());
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void testResource(@Suspended final AsyncResponse async) {
        redisConnector.test();
        async.resume("eco");
    }

    private void writeOutboundEvent(String channel, PlainMessageDto plainMessageDto , ChunkedOutput<OutboundEvent> seq) {
        try {
            seq.write(new OutboundEvent.Builder().name(channel).data(String.class, plainMessageDto.toJson()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
