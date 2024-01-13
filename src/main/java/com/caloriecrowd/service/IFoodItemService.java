package com.caloriecrowd.service;

import com.caloriecrowd.model.CalorieResponse;
import com.caloriecrowd.model.SelectedFoodItem;

import java.util.List;

public interface IFoodItemService {
  public void addSelecteditems(List<SelectedFoodItem> listOfSelectedItems);

  public CalorieResponse currentCaloriesByUserId(String userId);
}
