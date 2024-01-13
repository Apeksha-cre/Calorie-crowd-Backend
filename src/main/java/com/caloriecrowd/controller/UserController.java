package com.caloriecrowd.controller;


import com.caloriecrowd.model.ApiUser;
import com.caloriecrowd.model.LoginResponse;
import com.caloriecrowd.repo.UserRepository;
import com.caloriecrowd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController
{
    @Autowired
    private IUserService userService;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public NutritionService nutritionService;
    @Autowired
    public FoodItemService selectedItemServices;
    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping(value="/signUp")
    public ApiUser addNewUser(@RequestBody ApiUser user){
        ApiUser createdUser=userService.createUser(user);
        return createdUser;
    }

    @PostMapping(value="/login")
    public LoginResponse authenticateUser(@RequestBody ApiUser loginUser) {

        var loginResponse = userService.logInUser(loginUser);
        var tokenResponse = authenticationService.generateToken(loginUser.getEmail(), loginUser.getPassword());

        if (tokenResponse.getBearerToken() != null){
        loginResponse.setBearerToken(tokenResponse.getBearerToken());
            loginResponse.setTtl(tokenResponse.getTtl());

    }
        return loginResponse;
    }
}
