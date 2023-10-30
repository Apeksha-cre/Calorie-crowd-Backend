package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.entity.NutritionFact;
import com.calorieCrowd.caloriecrowdAPIs.model.NutritionDetails;

import java.util.List;

public interface INutritionService {
    public List<NutritionDetails>  fetchNutritionDetails(String itemName);
    public List<NutritionDetails> mapNutritionFactToNutritionDetails(List<NutritionFact>nutritionFactsList);
}
