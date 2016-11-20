# Vertx EventBus plus Jersey example

This is a simple example about Vertx EventBus. Basically that I did is take a previous project called 'vertxJerseyExample' and deploy three verticles: 

- First verticle is the resource layer, a rest endpoint. Here we will handler the user request and create a data transfer object (dto) that would be passed to an other verticle. The serialization will be made by Google protobuf. 

- Second verticle (PingVerticle) will handler the dto that the resource layer send by the event bus, and then add a value to one of his properties. (Ping Value) 

- finally the third verticle will handler the dto that the previous layer(pingVerticle) send it, and then add another value to other property, giving a reply to the first verticle, though the second one. (Pong Value)

to sum up the workflow must be something like this:

User emit request ----> ResourceLayer ---> pingVerticle ---> pongVerticle ---> pingVerticle ---> ResourceLayer ---> user

In this project I use java8 completable futures in stead of 'third parties promises' in order to avoid a callback hell. Also I used googleProtobuf an a byte[] eventbus codec serialization in order to play with java objects, in stead of JsonObject. GoogleProtobuf is fine because as vertx support several languages so...you can write your verticle in the language that you need. 

 To launch this project just run the following commands 

 ```
 mvn clean install
 java -jar -Dlogback.configurationFile=src/main/resources/logback.xml -Dorg.vertx.logger-delegate-factory-class-name=org.vertx.java.core.logging.impl.SLF4JLogDelegateFactory jerseyPingPongExample-1.0.0-SNAPSHOT-fat.jar -conf ../src/main/resources/config.json 
  ```
  
  Then make some queries ...
   
```
 curl -H "content-type:application/json" -X GET http://localhost:3849/ping/pong
```  
  
  
 