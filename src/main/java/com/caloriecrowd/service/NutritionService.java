package com.caloriecrowd.service;

import com.caloriecrowd.entity.NutritionFactsEntity;
import com.caloriecrowd.model.NutritionDetails;
import com.caloriecrowd.repo.NutritionfactsRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NutritionService implements INutritionService {
  @Autowired NutritionfactsRepository nutritionfactsRepository;

  public List<NutritionDetails> fetchNutritionDetails(String itemName, String foodCategory) {
    List<NutritionFactsEntity> nutritionFactsEntities;

    if (!Strings.isEmpty(foodCategory)) {
      nutritionFactsEntities =
          nutritionfactsRepository.fetchNutritionDetailsByNameAndCategory(itemName, foodCategory);
    } else {
      nutritionFactsEntities = nutritionfactsRepository.fetchNutritionDetailsByName(itemName);
    }
    List<NutritionDetails> nutritionDetailsList =
        mapNutritionFactEntitiesToNutritionDetails(nutritionFactsEntities);

    return nutritionDetailsList;
  }

  private List<NutritionDetails> mapNutritionFactEntitiesToNutritionDetails(
      List<NutritionFactsEntity> nutritionFactsList) {
    List<NutritionDetails> nutritionDetailsList = new ArrayList<>();
    for (int i = 0; i < nutritionFactsList.size(); i++) {
      var nutritionDetail = mapNutritionFactEntityToNutritionDetails(nutritionFactsList.get(i));
      nutritionDetailsList.add(nutritionDetail);
    }
    return nutritionDetailsList;
  }

  private NutritionDetails mapNutritionFactEntityToNutritionDetails(
      NutritionFactsEntity nutritionFactsEntity) {
    NutritionDetails nutritionDetails = new NutritionDetails();
    nutritionDetails.setCalorie(nutritionFactsEntity.getCalorie());
    nutritionDetails.setFoodId(nutritionFactsEntity.getFoodId());
    nutritionDetails.setFoodName(nutritionFactsEntity.getFoodName());
    nutritionDetails.setFoodCategory(nutritionFactsEntity.getFoodCategory());
    nutritionDetails.setProtein(nutritionFactsEntity.getProtein());
    nutritionDetails.setNetCarb(nutritionFactsEntity.getNetCarb());
    return nutritionDetails;
  }
}
