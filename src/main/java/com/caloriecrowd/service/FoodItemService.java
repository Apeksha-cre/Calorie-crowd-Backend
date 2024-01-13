package com.caloriecrowd.service;

import com.caloriecrowd.entity.SelectedItemEntity;
import com.caloriecrowd.model.CalorieResponse;
import com.caloriecrowd.model.SelectedFoodItem;
import com.caloriecrowd.repo.SelectedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FoodItemService implements IFoodItemService {
  @Autowired SelectedItemRepository selectedItemRepository;
  private List<SelectedItemEntity> mapSelectedFoodItemsToSelectedItems(
      List<SelectedFoodItem> listOfSelectedFoodItems) {

    List<SelectedItemEntity> listOfSelectedItems = new ArrayList<>();

    for (int i = 0; i < listOfSelectedFoodItems.size(); i++) {
      SelectedItemEntity selectedItems = new SelectedItemEntity();
      String date = LocalDate.now().toString();
      SelectedFoodItem selectedFoodItems = listOfSelectedFoodItems.get(i);
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

  public void addSelecteditems(List<SelectedFoodItem> listOfSelectedItems) {
    var selectedItemEntities = mapSelectedFoodItemsToSelectedItems(listOfSelectedItems);
    selectedItemRepository.saveAll(selectedItemEntities);
  }

  public CalorieResponse currentCaloriesByUserId(String userId) {
    String cUserId = userId;
    Integer totalCalorie = 0;
    Integer totalProtein = 0;
    Integer totalcarb = 0;
    String date = LocalDate.now().toString();
    // String currentUserId=selectedItems.getUserId();
    List<Integer> calories = selectedItemRepository.fatchCalorieOnDate(date, cUserId);
    List<Integer> protein = selectedItemRepository.fatchProteinOnDate(date, cUserId);
    List<Integer> carb = selectedItemRepository.fatchCarbOnDate(date, cUserId);

    for (int i : calories) {
      totalCalorie += i;
    }
    for (int i : protein) {
      totalProtein += i;
    }
    for (int i : carb) {
      totalcarb += i;
    }

    CalorieResponse calorieResponse = new CalorieResponse();
    calorieResponse.setTotalCalorie(totalCalorie);
    calorieResponse.setTotalProtein(totalProtein);
    calorieResponse.setTotalCarb(totalcarb);
    return calorieResponse;
  }
}
