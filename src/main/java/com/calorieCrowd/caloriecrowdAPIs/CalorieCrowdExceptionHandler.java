package com.calorieCrowd.caloriecrowdAPIs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class CalorieCrowdExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleInvalidAuth(){
return ResponseEntity.status(401).body("Invalid Token");
    }
}
