package com.caloriecrowd.controller;

import com.caloriecrowd.model.CalorieResponse;
import com.caloriecrowd.model.SelectedFoodItem;
import com.caloriecrowd.service.IFoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CalorieController {

  @Autowired public IFoodItemService foodItemService;

  @GetMapping(value = "/calorie/{userId}")
  public CalorieResponse getCaloriesForUser(@PathVariable("userId") String userId) {
    CalorieResponse calorieResponse = foodItemService.currentCaloriesByUserId(userId);
    return calorieResponse;
  }

  @PostMapping(value = "/calorie/add")
  public CalorieResponse addCalories(@RequestBody List<SelectedFoodItem> selectedFoodItems) {
    foodItemService.addSelecteditems(selectedFoodItems);
    String currentUserId = selectedFoodItems.get(0).getUserId();
    CalorieResponse calorieResponse = foodItemService.currentCaloriesByUserId(currentUserId);
    return calorieResponse;
  }
}
