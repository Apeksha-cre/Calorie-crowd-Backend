package com.calorieCrowd.caloriecrowdAPIs.controller;


import com.calorieCrowd.caloriecrowdAPIs.model.ApiUser;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginUser;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApiController
{
    @Autowired
    private IUserService userService;
    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/")
    public String getStart(){
        return "welcome to the calorieCrowd Api";
    }

    @PostMapping(value="/save")
    public ApiUser addNewUser(@RequestBody ApiUser user){
        ApiUser createdUser=userService.createUser(user);
        return createdUser;
    }

    @PostMapping(value="/login")
    public LoginResponse authenticateUser(@RequestBody LoginUser loginuser){
        LoginResponse loginresponse=userService.logInUser(loginuser);
        return loginresponse;
    }

//    @GetMapping(value = '/getcalorieByName')
//    public List<NutritionDetails>nutritionDetailsList=userRepository.getNutritionByName(String foodName);





}
