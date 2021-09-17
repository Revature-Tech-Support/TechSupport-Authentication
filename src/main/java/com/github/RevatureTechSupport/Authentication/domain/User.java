package com.github.RevatureTechSupport.Authentication.domain;

import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Table("User")
public class User {
  @PrimaryKey private UUID userID;
  private String username;
  private String password;
  private boolean isTechAgent;

  @Nonnull
  public static User from(User a) {
    return new User(a.userID, a.username, a.password, a.isTechAgent);
  }

  public User() {}

  // Constructor for login. Don't know isTechAgent or userID yet.
  public User(String username, String password) {
    this.userID = UUID.randomUUID();
    this.username = username;
    this.password = password;
    this.isTechAgent = false;
  }

  // Constructor for registration. Creates new userID for user.
  public User(String username, String password, boolean isTechAgent){
    this.userID = UUID.randomUUID();
    this.username = username;
    this.password = password;
    this.isTechAgent = isTechAgent;
  }

  // Constructor for full User for when pulling from repository.
  public User(UUID userID, String username, String password, boolean isTechAgent) {
    this.userID = userID;
    this.username = username;
    this.password = password;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean getIsTechAgent() {
    return isTechAgent;
  }

  public void setIsTechAgent(boolean isTechAgent) {
    this.isTechAgent = isTechAgent;
  }

  public boolean testPassword(String hashed_password){
    return BCrypt.checkpw(this.password, hashed_password);
  }
}
