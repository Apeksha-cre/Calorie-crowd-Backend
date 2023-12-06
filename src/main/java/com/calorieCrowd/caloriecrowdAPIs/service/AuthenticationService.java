package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.model.AuthResponse;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public AuthResponse generateToken(String username, String password) {
        var userId =userRepository.findByEmail(username,password);
        if (userId == null){
            //user unauthorized throw exception
        }
        var tokenResponse= jwtUtil.getAuthTokenResponse(username);

        return tokenResponse;
    }
}
