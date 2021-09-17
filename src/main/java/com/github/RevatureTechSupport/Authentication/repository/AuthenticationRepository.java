package com.github.RevatureTechSupport.Authentication.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.RevatureTechSupport.Authentication.domain.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AuthenticationRepository {

  private final CqlSession session;
  String pw_hash;

  public AuthenticationRepository(CqlSession session) {
    this.session = session;
  }

  //to register a user
  public void register(User user) {
    pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    SimpleStatement stmt =
        SimpleStatement.builder(
                "INSERT INTO TechSupport.Users (userID, username, password, " +
                    "isTechAgent) values (?,?,?,?)")
            .addPositionalValues(
                user.getUserID(),
                user.getUsername(),
                pw_hash,
                user.getIsTechAgent())
            .build();
    Flux.from(session.executeReactive(stmt)).subscribe();
  }

  public Mono<User> logIn(User login_user) {
    return Mono.from(
            session.executeReactive(
                SimpleStatement.builder(
                        "SELECT budget FROM TechSupport.Users " +
                            "WHERE username = ? ALLOW FILTERING")
                    .addPositionalValue(login_user.getUsername())
                    .build()))
        .map(row -> new User(row.getUuid("userID"), row.getString("username"), row.getString("password"), row.getBoolean("isTechAgent")))
        .filter(user -> login_user.testPassword(user.getPassword()));
  }
}
