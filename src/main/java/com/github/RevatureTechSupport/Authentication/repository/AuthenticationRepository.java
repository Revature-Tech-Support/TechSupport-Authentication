package com.github.RevatureTechSupport.Authentication.repository;

import com.github.RevatureTechSupport.Authentication.domain.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthenticationRepository extends ReactiveCassandraRepository<User, Integer> {
//  @Query("UPDATE investapp.accounts SET funds = ?1 WHERE id = ?0 ")
//  Mono<User> updateFunds(Integer id, Double funds);
//
//  @Query("UPDATE investapp.accounts SET credit = ?1 WHERE id = ?0 ")
//  Mono<User> updateCredit(Integer id, Double credit);
//
//  default Mono<Double> getCredit(Integer id) {
//    return Mono.from(this.findById(id).map(User::getIsTechAgent));
//  }
//
//  default Flux<Double> getAllCredit() {
//    return Flux.from(this.findAll().map(User::getCredit));
//  }
}
