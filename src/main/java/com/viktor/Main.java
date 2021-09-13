package com.viktor;


import com.viktor.framework.Server;
import com.viktor.framework.resolver.argument.RequestHandlerMethodArgumentResolver;
import com.viktor.framework.resolver.argument.RequestHeaderHandlerMethodArgumentResolver;
import com.viktor.framework.resolver.argument.ResponseHandlerMethodArgumentResolver;
import lombok.extern.java.Log;

@Log
public class Main {
  public static void main(String[] args) throws InterruptedException {
    final var server = new Server();
    server.autoRegisterHandlers("org.example.http.app");
    server.addArgumentResolver(
        new RequestHandlerMethodArgumentResolver(),
        new ResponseHandlerMethodArgumentResolver(),
        new RequestHeaderHandlerMethodArgumentResolver()
    );
//      new Thread(() -> {
//      try {
//        Thread.sleep(50000);
//        server.stop();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }).start();

    server.listen(9999);
  }
}
