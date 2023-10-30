package com.calorieCrowd.caloriecrowdAPIs.controller;


import com.calorieCrowd.caloriecrowdAPIs.model.ApiUser;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginUser;
import com.calorieCrowd.caloriecrowdAPIs.model.NutritionDetails;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.service.IUserService;
import com.calorieCrowd.caloriecrowdAPIs.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ApiController
{
    @Autowired
    private IUserService userService;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public NutritionService nutritionService;

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

    @GetMapping(value = "/food")
    public List<NutritionDetails> getNutritionDetails(@RequestParam("foodName") String itemName){
     List<NutritionDetails>nutritionDetailsList;
     nutritionDetailsList =nutritionService.fetchNutritionDetails(itemName);
    return nutritionDetailsList;
}





}
