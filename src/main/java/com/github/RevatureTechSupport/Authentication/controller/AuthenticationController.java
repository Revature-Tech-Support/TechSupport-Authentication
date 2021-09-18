package com.github.RevatureTechSupport.Authentication.controller;

import ch.qos.logback.classic.Logger;
import com.github.RevatureTechSupport.Authentication.domain.User;
import com.github.RevatureTechSupport.Authentication.service.AuthenticationService;
import java.util.UUID;
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

  @PostMapping("")
  public Mono<passbackUser> createUser(@RequestBody registerUserJSON userJSON) {
    User new_user = new User(userJSON.getUsername(), userJSON.getPassword(), userJSON.getIsTechAgentBool());
    log.info("Creating user " + new_user.getUsername());
    return service.createUser(new_user).map(this::userToPassback);
  }

  @GetMapping("/login")
  public Mono<passbackUser> getUser(@RequestBody loginUserJSON userJSON) {
    User login_user = new User(userJSON.getUsername(), userJSON.getPassword());
    log.info("Accessing user " + login_user.getUsername());
    return service.getUser(login_user).map(this::userToPassback);
  }

  private passbackUser userToPassback(User recieved_user){
    return new passbackUser(recieved_user.getUserID(), recieved_user.getUsername(), recieved_user.getIsTechAgent());
  }
}

// This is dirty code to ensure the JSON gets properly mapped.
// It didn't seem to be picking the correct constructors for User. So made these to just grab
// the JSON data I needed and then pick the correct constructor from there.
class registerUserJSON{
  private String username;
  private String password;
  private String isTechAgent;

  public boolean getIsTechAgentBool() {
    return (this.isTechAgent.contains("True") || this.isTechAgent.contains("true"));
  }

  public registerUserJSON(){
    this.username = "None";
    this.password = "None";
    this.isTechAgent = "None";
  }
  public registerUserJSON(String username, String password, String isTechAgent){
    this.username = username;
    this.password = password;
    this.isTechAgent = isTechAgent;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getIsTechAgent() {
    return isTechAgent;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setIsTechAgent(String techAgent) {
    isTechAgent = techAgent;
  }
}

class loginUserJSON{
  private String username;
  private String password;
  public loginUserJSON(){
    this.username = "None";
    this.password = "None";
  }
  public loginUserJSON(String username, String password){
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

class passbackUser{
  private UUID userID;
  private String username;
  private boolean isTechAgent;
  public passbackUser(UUID userID, String username, boolean isTechAgent){
    this.userID = userID;
    this.username = username;
    this.isTechAgent = isTechAgent;
  }

  public UUID getUserID() {
    return userID;
  }

  public void setUserID(UUID userID) {
    this.userID = userID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public boolean isTechAgent() {
    return isTechAgent;
  }

  public void setTechAgent(boolean techAgent) {
    isTechAgent = techAgent;
  }
}