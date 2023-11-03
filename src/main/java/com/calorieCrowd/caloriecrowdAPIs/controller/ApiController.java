package com.calorieCrowd.caloriecrowdAPIs.controller;


import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import com.calorieCrowd.caloriecrowdAPIs.model.*;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.service.IUserService;
import com.calorieCrowd.caloriecrowdAPIs.service.NutritionService;
import com.calorieCrowd.caloriecrowdAPIs.service.SelectedItemServices;
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

    @Autowired
    public SelectedItemServices selectedItemServices;
   // @Autowired
   // public SelectedItems selectedItems;

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
    public List<NutritionDetails> getNutritionDetails(@RequestParam("foodName") String itemName,@RequestParam(name="foodCategory", required = false) String foodCategory){
     List<NutritionDetails>nutritionDetailsList;
     if(foodCategory!= null)
     {
         nutritionDetailsList =nutritionService.fetchNutritionDetails(itemName,foodCategory);
     }else{
     nutritionDetailsList =nutritionService.fetchNutritionDetails(itemName);}
    return nutritionDetailsList;
    }

    @PostMapping(value="/calorie/add")
    public CalorieResponse addCalories(@RequestBody List<SelectedFoodItems> listOfSelectedFoodItems)
    {
        List<SelectedItems> listOfSelectedItems=selectedItemServices.mapSelectedFoodItemsToSelectedItems(listOfSelectedFoodItems);
        CalorieResponse calorieResponse=selectedItemServices.addSelecteditems(listOfSelectedItems);
        return calorieResponse;
    }

}
