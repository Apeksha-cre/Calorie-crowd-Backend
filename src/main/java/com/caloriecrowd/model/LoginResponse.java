package com.caloriecrowd.model;

import com.caloriecrowd.entity.UserEntity;

public class LoginResponse {
  private UserEntity userEntity;
  private String loginMessage;

  private String bearerToken;

  private long ttl;

  public UserEntity getUser() {
    return userEntity;
  }

  public void setUser(UserEntity userEntity) {
    this.userEntity = userEntity;
  }

  public String getLoginMessage() {
    return loginMessage;
  }

  public void setLoginMessage(String loginMessage) {
    this.loginMessage = loginMessage;
  }

  public String getBearerToken() {
    return bearerToken;
  }

  public void setBearerToken(String bearerToken) {
    this.bearerToken = bearerToken;
  }

  public long getTtl() {
    return ttl;
  }

  public void setTtl(long ttl) {
    this.ttl = ttl;
  }
}
