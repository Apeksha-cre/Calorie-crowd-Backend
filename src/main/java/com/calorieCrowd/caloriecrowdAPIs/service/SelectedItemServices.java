package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import com.calorieCrowd.caloriecrowdAPIs.model.CalorieResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.SelectedFoodItems;
import com.calorieCrowd.caloriecrowdAPIs.repo.SelectedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class SelectedItemServices implements ISelectedItemServices {


    @Autowired
    SelectedItemRepository selectedItemRepository;
    //String currentUserId = null;
    public List<SelectedItems> mapSelectedFoodItemsToSelectedItems(List<SelectedFoodItems> listOfSelectedFoodItems) {

        List<SelectedItems> listOfSelectedItems = new ArrayList<>();


        for (int i = 0; i < listOfSelectedFoodItems.size(); i++) {
            SelectedItems selectedItems = new SelectedItems();
            String date = LocalDate.now().toString();
            SelectedFoodItems selectedFoodItems = listOfSelectedFoodItems.get(i);
            selectedItems.setFoodId(selectedFoodItems.getFoodId());
            selectedItems.setFoodQuantity(selectedFoodItems.getFoodQuantity());
            selectedItems.setUserId(selectedFoodItems.getUserId());
            selectedItems.setCalories(selectedFoodItems.getCalories());
            selectedItems.setFoodName(selectedFoodItems.getFoodName());
            selectedItems.setTotalCalorie(selectedFoodItems.getTotalCalorie());
            selectedItems.setProtein(selectedFoodItems.getProtein());
            selectedItems.setTotalProtein(selectedFoodItems.getTotalProtein());
            selectedItems.setCarb(selectedFoodItems.getCarb());
            selectedItems.setTotalCarb(selectedFoodItems.getTotalCarb());
            selectedItems.setDate(date);
            listOfSelectedItems.add(selectedItems);

        }



        return listOfSelectedItems;
    }

    public void addSelecteditems(List<SelectedItems>listOfSelectedItems)
    {
       // Integer totalCalorie=0;
        //String date = LocalDate.now().toString();
        for(SelectedItems selectedItems : listOfSelectedItems) {

            selectedItemRepository.save(selectedItems);
        }
//            List<Integer> calories=selectedItemRepository.fatchCalorieOnDate(date);
//            for(int i: calories)
//            {
//                totalCalorie+=i;
//            }
//            CalorieResponse calorieResponse=new CalorieResponse();
//            calorieResponse.setTotalCalorie(totalCalorie);
//        return calorieResponse;
    }


    public CalorieResponse currentCalorie(String userId)
    {
        String cUserId=userId;
        Integer totalCalorie=0;
        Integer totalProtein=0;
        Integer totalcarb=0;
        String date = LocalDate.now().toString();
        //String currentUserId=selectedItems.getUserId();
        List<Integer> calories=selectedItemRepository.fatchCalorieOnDate(date,cUserId);
        List<Integer> protein=selectedItemRepository.fatchProteinOnDate(date,cUserId);
        List<Integer> carb=selectedItemRepository.fatchCarbOnDate(date,cUserId);


        for(int i: calories)
        {
            totalCalorie+=i;
        }
        for(int i: protein)
        {
            totalProtein+=i;
        }
        for(int i: carb)
        {
            totalcarb+=i;
        }

        CalorieResponse calorieResponse=new CalorieResponse();
        calorieResponse.setTotalCalorie(totalCalorie);
        calorieResponse.setTotalProtein(totalProtein);
        calorieResponse.setTotalCarb(totalcarb);
        return calorieResponse;
    }

}
