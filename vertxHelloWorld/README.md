# HelloWorld Verticles

This is a simple example about Vertx Verticles. A verticle is like a lego brick to build your app with high availability and easy development.   

There are three kind of verticles:

- Standard verticle : events handler by an event loop.
- Worker verticle : It’s not using the event loop, it’s using a thread from a vertx
  thread pool. This verticle use to be used to run blocking code, as they won’t block
  any event loops.
- Multi-threaded worker verticles : are like a common worker verticle but it can be
  executed concurrently by different threads.
 



