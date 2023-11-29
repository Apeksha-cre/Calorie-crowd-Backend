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
    String currentUserId = null;
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
            selectedItems.setDate(date);
            listOfSelectedItems.add(selectedItems);
          currentUserId=selectedItems.getUserId();
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
public String getcurrentUserId()
{
    String userId=currentUserId;
    return userId;
}

    public CalorieResponse currentCalorie(String userId)
    {
        String cUserId=userId;
        Integer totalCalorie=0;
        String date = LocalDate.now().toString();
        //String currentUserId=selectedItems.getUserId();
        List<Integer> calories=selectedItemRepository.fatchCalorieOnDate(date,cUserId);

        for(int i: calories)
        {
            totalCalorie+=i;
        }

        CalorieResponse calorieResponse=new CalorieResponse();
        calorieResponse.setTotalCalorie(totalCalorie);
        return calorieResponse;
    }

}
