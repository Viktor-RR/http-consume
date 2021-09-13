package com.viktor.handler;


import com.viktor.framework.HttpMethods;
import com.viktor.framework.annotation.RequestHeader;
import com.viktor.framework.annotation.RequestMapping;
import com.viktor.framework.exception.RequestHandleException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CoursesHandler {
  @RequestMapping(method = HttpMethods.GET, path = "/courses")
  public void getCourses(
      OutputStream response,
      @RequestHeader("Username") String username
  ) {
    final var body = "{\"courses\": []}" + username;
    try {
      response.write(
          (
              // language=HTTP
              "HTTP/1.1 200 OK\r\n" +
                  "Content-Length: " + body.length() + "\r\n" +
                  "Content-Type: application/json\r\n" +
                  "Connection: close\r\n" +
                  "\r\n" +
                  body
          ).getBytes(StandardCharsets.UTF_8)
      );
    } catch (IOException e) {
      throw new RequestHandleException(e);
    }
  }
//  @RequestMapping(method = HttpMethods.POST, path = "/index.html")
//  public void getIndex(
//          OutputStream response,
//          @RequestHeader("Username") String username, @RequestHeader("Password") String password
//  ) {
//    final var body = "";
//    try {
//      response.write(
//              (
//                      // language=HTTP
//                      "HTTP/1.1 200 OK\r\n" +
//                              "Content-Length: " + body.length() + "\r\n" +
//                              "Content-Type: application/json\r\n" +
//                              "Connection: close\r\n" +
//                              "\r\n" +
//                              body
//              ).getBytes(StandardCharsets.UTF_8)
//      );
//    } catch (IOException e) {
//      throw new RequestHandleException(e);
//    }
//  }
}
