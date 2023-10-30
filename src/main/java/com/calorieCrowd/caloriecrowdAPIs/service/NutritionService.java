package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.entity.NutritionFact;
import com.calorieCrowd.caloriecrowdAPIs.model.NutritionDetails;
import com.calorieCrowd.caloriecrowdAPIs.repo.NutritionfactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class NutritionService implements INutritionService
{
    @Autowired
    NutritionfactsRepository nutritionfactsRepository;
    public List<NutritionDetails> fetchNutritionDetails(String itemName)
    {
        List<NutritionFact>nutritionFactsList =nutritionfactsRepository.fetchNutritionDetailsByName(itemName);
        List<NutritionDetails>nutritionDetailsList=mapNutritionFactToNutritionDetails(nutritionFactsList);

        return nutritionDetailsList;
    }
    public List<NutritionDetails> fetchNutritionDetails(String itemName, String foodCategory){
        List<NutritionFact>nutritionFactsList =nutritionfactsRepository.fetchNutritionDetailsByNameAndCategory(itemName,foodCategory);
        List<NutritionDetails>nutritionDetailsList=mapNutritionFactToNutritionDetails(nutritionFactsList);

        return nutritionDetailsList;
    }

    public List<NutritionDetails> mapNutritionFactToNutritionDetails(List<NutritionFact>nutritionFactsList)
    {
        List<NutritionDetails>nutritionDetailsList=new ArrayList<>();
        for(int i=0;i<nutritionFactsList.size();i++)
        {
            NutritionFact nutritionFact=nutritionFactsList.get(i);
            NutritionDetails nutritionDetails=new NutritionDetails();
            nutritionDetails.setCalorie(nutritionFact.getCalorie());
            nutritionDetails.setFoodId(nutritionFact.getFoodId());
            nutritionDetails.setFoodName(nutritionFact.getFoodName());
            nutritionDetails.setFoodCategory(nutritionFact.getFoodCategory());
            nutritionDetails.setProtein(nutritionFact.getProtein());
            nutritionDetails.setNetCarb(nutritionFact.getNetCarb());
            nutritionDetailsList.add(nutritionDetails);
        }
        //System.out.println(nutritionDetailsList);
        return nutritionDetailsList;

    }

}
