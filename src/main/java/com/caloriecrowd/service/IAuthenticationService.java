package com.caloriecrowd.service;

import com.caloriecrowd.model.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

  public AuthResponse generateToken(String username, String password);
}
