package com.github.RevatureTechSupport.Authentication.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.annotation.Nonnull;

@Table("User")
public class User {
  @PrimaryKey private Integer userID;
  private String username;
  private String password;
  private boolean isTechAgent;

  @Nonnull
  public static User from(User a) {
    return new User(a.userID, a.username, a.password, a.isTechAgent);
  }

  public User() {}

  public User(Integer userID, String username, String password) {
    this.userID = userID;
    this.username = username;
    this.password = password;
  }

  public User(Integer userID, String username, String password, boolean isTechAgent) {
    this.userID = userID;
    this.username = username;
    this.password = password;
    this.isTechAgent = isTechAgent;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String gePassword() {
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
}
