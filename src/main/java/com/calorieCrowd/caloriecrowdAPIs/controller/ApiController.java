package com.calorieCrowd.caloriecrowdAPIs.controller;


import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import com.calorieCrowd.caloriecrowdAPIs.model.*;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import com.calorieCrowd.caloriecrowdAPIs.service.*;
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

    @Autowired
    private AuthenticationService authenticationService;
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
    public LoginResponse authenticateUser(@RequestBody LoginUser loginuser) {
        var token = authenticationService.generateToken(loginuser.getEmail(), loginuser.getPassword());
        var loginResponse = userService.logInUser(loginuser);

        if (token.getBearerToken() != null){
        loginResponse.setBearerToken(token.getBearerToken());
            loginResponse.setTtl(token.getTtl());

    }
        return loginResponse;
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
//    AnalysisResponse analysisResponse=imageAnalysisService.imageAnalysis(image);
//    return analysisResponse;

    var response=new AnalysisResponse();
    var segmentResult1= new SegmentationResult();
    var recognisionResult1= new RecognizationResult();
    recognisionResult1.setName("pie");
    var recognisionResult2= new RecognizationResult();
    recognisionResult2.setName("apple pie");
    segmentResult1.setRecognition_results(List.of(recognisionResult1,recognisionResult2));

    response.setSegmentation_results(List.of(segmentResult1));
    return response;
}

}
