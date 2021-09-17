package com.github.RevatureTechSupport.Authentication.service;

import com.github.RevatureTechSupport.Authentication.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthenticationService {

  private final com.github.RevatureTechSupport.Authentication.repository.AuthenticationRepository repo;

  public AuthenticationService(com.github.RevatureTechSupport.Authentication.repository.AuthenticationRepository repo) {
    this.repo = repo;
  }
  public void createUser(User new_user){
    repo.register(new_user);
  }

  public Mono<User> getUser(User login_user){
    return repo.logIn(login_user);
  }
}
