package com.caloriecrowd.controller;

import com.caloriecrowd.model.NutritionDetails;
import com.caloriecrowd.service.NutritionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class FoodController {

  public NutritionService nutritionService;

  @GetMapping(value = "/food")
  public List<NutritionDetails> getNutritionDetails(
      @RequestParam("foodName") String itemName,
      @RequestParam(name = "foodCategory", required = false) String foodCategory) {

    List<NutritionDetails> nutritionDetailsList =
        nutritionService.fetchNutritionDetails(itemName, foodCategory);

    return nutritionDetailsList;
  }
}
