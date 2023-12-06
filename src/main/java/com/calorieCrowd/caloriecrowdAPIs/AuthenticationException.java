package com.calorieCrowd.caloriecrowdAPIs;

public class AuthenticationException extends RuntimeException{
    private String message;

    public AuthenticationException(String message) {
        super(message);
        this.message = message;
    }
}
