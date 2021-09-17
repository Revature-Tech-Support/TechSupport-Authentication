package com.github.RevatureTechSupport.Authentication.controller;

import ch.qos.logback.classic.Logger;
import com.github.RevatureTechSupport.Authentication.domain.User;
import com.github.RevatureTechSupport.Authentication.service.AuthenticationService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");

  private final AuthenticationService service;

  public AuthenticationController(AuthenticationService service) {
    log.info("Creating new AccountController");
    this.service = service;
  }

  @PostMapping("/")
  public void createUser(@RequestBody User my_user) {
    log.info("Creating user " + my_user.getUsername());
    service.createUser(my_user);
  }

  @GetMapping("/login")
  public Mono<User> getUser(@RequestBody User my_user) {
    log.info("Accessing user " + my_user.getUsername());
    return service.getUser(my_user);
  }
}
