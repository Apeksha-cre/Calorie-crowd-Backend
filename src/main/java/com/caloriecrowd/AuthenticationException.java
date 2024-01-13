package com.caloriecrowd;

public class AuthenticationException extends RuntimeException {
  private String message;

  public AuthenticationException(String message) {
    super(message);
    this.message = message;
  }
}
