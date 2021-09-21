package com.github.RevatureTechSupport.Authentication;

import com.github.RevatureTechSupport.Authentication.controller.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
// @EnableEurekaClient
@PropertySource("classpath:application.properties")
public class AuthenticationApp {
  private @Autowired
  AuthenticationController controller;

  @Value("${server.port}")
  private String port;

  public static void main(String[] args) {
    SpringApplication.run(AuthenticationApp.class, args);
  }

  /**
   * A bean to handle the netty HTTP server for the REST API.
   *
   * @param context: The application context
   * @return A new HTTP server
   */
  @Bean
  public HttpServer httpServer(ApplicationContext context) {
    HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
    ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
    return HttpServer.create().port(Integer.parseInt(port)).handle(adapter);
  }
}
