package com.calorieCrowd.caloriecrowdAPIs.controller;

import com.calorieCrowd.caloriecrowdAPIs.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CalorieCrowdExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleInvalidAuth(RuntimeException ex, WebRequest request){
return ResponseEntity.status(401).body("Invalid Token");
    }
}
