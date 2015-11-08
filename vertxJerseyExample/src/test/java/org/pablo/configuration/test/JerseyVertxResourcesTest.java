package org.pablo.configuration.test;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class JerseyVertxResourcesTest {

	private Vertx vertx;
	
	@Before
	public void setUp(TestContext context) {
		vertx = Vertx.vertx();
		DeploymentOptions options = new DeploymentOptions();
		final JsonObject jsonConfig = new JsonObject(vertx.fileSystem().readFileBlocking("src/main/resources/verticle.cfg").toString());
		options.setConfig(jsonConfig);
		vertx.deployVerticle("java-hk2:org.pablo.configuration.VerticleConf",options, context.asyncAssertSuccess());
	}

	@After
	public void tearDown(TestContext context) {
		vertx.close(context.asyncAssertSuccess());
	}

	@Test
	public void testResource(TestContext context) {
		final Async async = context.async();

		vertx.createHttpClient().getNow(3849, "localhost", "/resource", response -> {
			response.handler(body -> {
				context.assertTrue(body.toString().contains("when.java"));
				async.complete();
			});
		});
	}
	
	
	@Test
	public void testCurrentTime(TestContext context) {
		final Async async = context.async();

		vertx.createHttpClient().getNow(3849, "localhost", "/resource/currentTime", response -> {
			response.handler(body -> {
				final JsonObject jsonResult = new JsonObject(body.toString());
				context.assertNotNull(jsonResult.containsKey("timeInISO8601"));
				context.assertNotNull(jsonResult.getValue("timeInISO8601"));
				async.complete();
			});
		});
	}
	
	
	@Test
	public void testCreatePerson(TestContext context) {
		final Async async = context.async();
		final JsonObject jsonBody = new JsonObject();
		jsonBody.put("firstname", "pablo");
		jsonBody.put("lastname", "Gonzalez");
		vertx.createHttpClient().post(3849, "localhost", "/resource", response -> {
			response.handler(body -> {
				final JsonObject jsonResult = new JsonObject(body.toString());
				context.assertNotNull(jsonResult.containsKey("id"));
				context.assertNotNull(jsonResult.getValue("id"));
				async.complete();
			});
		})
		.putHeader("Content-Type", "application/json")
		.putHeader("Content-Length", Integer.toString(jsonBody.encode().length()))
		.write(jsonBody.encode())
		.end();
	}
	
	
	@Test
	public void testCreatePersonWrong(TestContext context) {
		final Async async = context.async();
		final JsonObject jsonBody = new JsonObject();
		jsonBody.put("firstname", "pa");
		jsonBody.put("lastname", "Gonzalez");
		vertx.createHttpClient().post(3849, "localhost", "/resource", response -> {
			context.assertEquals(400, response.statusCode());
			async.complete();
		})
		.putHeader("Content-Type", "application/json")
		.putHeader("Content-Length", Integer.toString(jsonBody.encode().length()))
		.write(jsonBody.encode())
		.end();
	}
	
}
