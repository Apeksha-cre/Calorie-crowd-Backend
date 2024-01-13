package com.caloriecrowd.model;

public class AuthResponse {
  private long ttl;
  private String bearerToken;

  public AuthResponse(long ttl, String bearerToken) {
    this.ttl = ttl;
    this.bearerToken = bearerToken;
  }

  public long getTtl() {
    return ttl;
  }

  public String getBearerToken() {
    return bearerToken;
  }
}
