package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.model.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

    public AuthResponse generateToken(String username, String password);


}
