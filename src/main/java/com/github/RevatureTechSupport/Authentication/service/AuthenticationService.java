package com.github.RevatureTechSupport.Authentication.service;

import com.github.RevatureTechSupport.Authentication.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthenticationService {

//  private final com.github.RevatureTechSupport.Authentication.repository.AuthenticationRepository repo;
//
//  public AuthenticationService(com.github.RevatureTechSupport.Authentication.repository.AuthenticationRepository repo) {
//    this.repo = repo;
//  }
//
//  public Flux<User> getAll() {
//    return repo.findAll();
//  }
//
//  public Mono<User> get(Integer id) {
//    return repo.findById(id);
//  }
//
//  public Mono<Double> getCredit(Integer id) {
//    return repo.getCredit(id);
//  }
//
//  public Mono<Double> getFunds(Integer id) {
//    return repo.getFunds(id);
//  }
//
//  public Flux<Double> getAllFunds() {
//    return repo.getAllFunds();
//  }
//
//  public Flux<Double> getAllCredit() {
//    return repo.getAllCredit();
//  }
//
//  public Mono<User> create(User account) {
//    return repo.save(account);
//  }
//
//  public Mono<Void> delete(Integer id) {
//    return repo.deleteById(id);
//  }
//
//  public Mono<User> updateFunds(Integer id, double funds) {
//    return repo.updateFunds(id, funds);
//  }
//
//  public Mono<User> updateCredit(Integer id, double credit) {
//    return repo.updateCredit(id, credit);
//  }
}
