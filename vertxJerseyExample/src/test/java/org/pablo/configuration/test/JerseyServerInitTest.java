package org.pablo.configuration.test;

import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.englishtown.vertx.jersey.JerseyOptions;
import com.englishtown.vertx.jersey.JerseyServer;
import com.englishtown.vertx.jersey.JerseyVerticle;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JerseyServerInitTest {

	JerseyVerticle jerseyVerticle;
    JsonObject config = new JsonObject();

    @Mock
    Vertx vertx;
    @Mock
    Context context;
    @Mock
    JerseyServer jerseyServer;
    @Mock
    JerseyOptions options;
    @Mock
    Future<Void> startedResult;
    @Mock
    AsyncResult<HttpServer> asyncResult;
    @Captor
    ArgumentCaptor<Handler<AsyncResult<HttpServer>>> handlerCaptor;
    

	@Before
	public void setUp() {
		when(vertx.getOrCreateContext()).thenReturn(context);
        when(context.config()).thenReturn(config);
        jerseyVerticle = new JerseyVerticle(jerseyServer, options);
        jerseyVerticle.init(vertx, context);
	}

	@Test
	public void testMyApplication() throws Exception {
		jerseyVerticle.start(startedResult);

        verify(startedResult, never()).complete();
        verify(startedResult, never()).fail(any(Throwable.class));

        verify(jerseyServer).init(any(JerseyOptions.class), handlerCaptor.capture());

        when(asyncResult.succeeded()).thenReturn(true).thenReturn(false);

        handlerCaptor.getValue().handle(asyncResult);
        verify(startedResult).complete();
        verify(startedResult, never()).fail(any(Throwable.class));

        handlerCaptor.getValue().handle(asyncResult);
        verify(startedResult).complete();
        verify(startedResult).fail(any(Throwable.class));

	}
}
