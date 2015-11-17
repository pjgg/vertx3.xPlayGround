# HelloWorld Verticles

This is a simple example about Vertx Verticles. A verticle is like a lego brick to build your app with high availability and easy development.   

There are three kind of verticles:

- Standard verticle : events handler by an event loop.
- Worker verticle : It’s not using the event loop, it’s using a thread from a vertx
  thread pool. This verticle use to be used to run blocking code, as they won’t block
  any event loops.
- Multi-threaded worker verticles : are like a common worker verticle but it can be
  executed concurrently by different threads.
 
This example, use standard verticle. To run it, just install vertx 3.x and then run the following commands:

 ```
vertx ~/vertxHelloWorld/src/main/java/org/pablo/configuration/Sender.java -cluster
 ```

The above command will launch send messages to an eventBus, every second. Yes you don't need to compile your Java class :)
When your sender verticle it's up and running, run the following commands

 ```
vertx ~/vertxPlayGround/vertxHelloWorld/src/main/resources/groovyVerticle/receiver.groovy -cluster
vertx ~/vertxPlayGround/vertxHelloWorld/src/main/resources/javascriptVerticle/receiver.js -cluster
 ```

Those verticles are consumer. Will consume the messages sent by Sender.java. And Yes!, they are written in groovy and javascript!, why not!. You can try to write your own verticle in Scala or python feel free. There are a lot of language supported by Vertx and all of them can work together. 

