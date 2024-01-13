package com.caloriecrowd.service;

import com.caloriecrowd.model.AuthResponse;
import com.caloriecrowd.repo.UserRepository;
import com.caloriecrowd.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
  @Autowired private UserRepository userRepository;
  @Autowired private JwtUtil jwtUtil;

  @Override
  public AuthResponse generateToken(String username, String password) {
    var userId = userRepository.findByEmail(username, password);
    if (userId == null) {
      // user unauthorized throw exception
    }
    var tokenResponse = jwtUtil.getAuthTokenResponse(username);

    return tokenResponse;
  }
}
