package com.calorieCrowd.caloriecrowdAPIs.controller;


import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import com.calorieCrowd.caloriecrowdAPIs.model.*;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.service.IUserService;
import com.calorieCrowd.caloriecrowdAPIs.service.ImageAnalysisService;
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
@Autowired
    public ImageAnalysisService imageAnalysisService;
    @GetMapping(value = "/")
    public String getStart(){
        return "welcome to the calorieCrowd Api";
    }

    @PostMapping(value="/signUp")
    public ApiUser addNewUser(@RequestBody ApiUser user){
        ApiUser createdUser=userService.createUser(user);
        return createdUser;
    }

    @PostMapping(value="/login")
    public LoginResponse authenticateUser(@RequestBody LoginUser loginuser){
        LoginResponse loginresponse=userService.logInUser(loginuser);
        return loginresponse;
    }
    @GetMapping(value="/calorie/{userId}")
   public CalorieResponse userCalorie(@PathVariable("userId") String userId)
    {
        System.out.println(userId);
        CalorieResponse calorieResponse=selectedItemServices.currentCalorie(userId);
        return calorieResponse;
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
        selectedItemServices.addSelecteditems(listOfSelectedItems);
        String userId=selectedItemServices.getcurrentUserId();
        CalorieResponse calorieResponse=selectedItemServices.currentCalorie(userId);
        return calorieResponse;
    }

@PostMapping(value="/image")
    public AnalysisResponse getImageAnalysis(@RequestBody String image)
{
    AnalysisResponse analysisResponse=imageAnalysisService.imageAnalysis(image);
    return analysisResponse;
}

}
