package org.pablo.repository;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CompletableFuture;

import org.pablo.domain.Person;
import org.pablo.utils.VertxBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class PersonRepositoryImpl implements PersonRepository {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final static MongoClient mongoClient = MongoClient.createShared(VertxBridge.INSTANCE.getVertx(), VertxBridge.INSTANCE.getVertx().getOrCreateContext().config().getJsonObject("mongoDb"));

	@Override
	public Person savePerson(Person person) {
		CompletableFuture<Person> savePromise = new CompletableFuture<Person>();
		mongoClient.save("products", new JsonObject(((Gson)new GsonBuilder().create()).toJson(person)), personId -> {
			person.setId(personId.result());
			savePromise.complete(person);
		});
		
		return savePromise.join();
	}

}
