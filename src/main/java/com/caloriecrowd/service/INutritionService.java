package com.caloriecrowd.service;

import com.caloriecrowd.model.NutritionDetails;
import java.util.List;

public interface INutritionService {
  public List<NutritionDetails> fetchNutritionDetails(String itemName, String foodCategory);
}
