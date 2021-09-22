package com.github.RevatureTechSupport.Authentication.service;

import com.github.RevatureTechSupport.Authentication.domain.User;
import com.github.RevatureTechSupport.Authentication.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthenticationService {

  private final AuthenticationRepository repo;

  public AuthenticationService(AuthenticationRepository repo) {
    this.repo = repo;
  }
  
  public Mono<User> createUser(User new_user) {
    return repo.logIn(new_user.getUsername())
        .defaultIfEmpty(new_user)
        .flatMap(this::saveUser)
        .filter(user -> new_user.testUserID(user.getUserID()));
  }

  private Mono<User> saveUser(User new_user) {
    return repo.save(new_user);
  }

  public Mono<User> getUser(User login_user) {
    return repo.logIn(login_user.getUsername()).filter(user -> login_user.testPassword(user.getPassword()));
  }
}
