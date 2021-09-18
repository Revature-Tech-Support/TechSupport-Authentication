package com.github.RevatureTechSupport.Authentication.repository;

import com.github.RevatureTechSupport.Authentication.domain.User;
import java.util.UUID;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthenticationRepository extends ReactiveCassandraRepository<User, UUID> {
  @Query(value="SELECT * FROM User WHERE username = ?0 ALLOW FILTERING", allowFiltering= true )
  Mono<User> logIn(String username);
}
