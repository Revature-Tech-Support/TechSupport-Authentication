package com.github.RevatureTechSupport.Authentication.controller;

import ch.qos.logback.classic.Logger;
import com.github.RevatureTechSupport.Authentication.domain.User;
import com.github.RevatureTechSupport.Authentication.service.AuthenticationService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

  private static final Logger log =
      (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("controller");

  private final AuthenticationService service;
  /**
   * Constructor for the Rest Controller
   *
   * @author Andrew Gregersen
   * @param service: The AccountService for this instance of the server
   */
  public AuthenticationController(AuthenticationService service) {
    log.info("Creating new AccountController");
    this.service = service;
  }
  /**
   * A REST endpoint (GET) to retrieve all accounts that are in the Cassandra Database
   *
   * @author Andrew Gregersen
   * @return A Flux of all Accounts in the database
   */
  @GetMapping("/login")
  public Flux<User> getAll() {
    log.info("Retrieving all users");
    return service.getAll();
  }

}
