# Vertx Jersey Mongo example

This is a simple example about Vertx Jersey, plus mongo module. Basically that I did is take a previous project called 'vertxJerseyExample' and add a repository layer connected to mongoDb. 
You can have a look to resource/verticle.cfg in order to know where is mongoDb located and how to connect it. 


To run this project just run the following commands:

 ```
mvn clean install

java -jar -Dlogback.configurationFile=src/main/resources/logback.xml -Dorg.vertx.logger-delegate-factory-class-name=org.vertx.java.core.logging.impl.SLF4JLogDelegateFactory jerseyMongoExample-1.0.0-SNAPSHOT-fat.jar -conf ../src/main/resources/config.json
 ```
 
 And then you can save some entities ... 
 
  ```
  curl -H "content-type:application/json" -X POST -d '{ "firstname":"Pablo","lastname":"gonzalez"}' http://localhost:3849/resource
  ```