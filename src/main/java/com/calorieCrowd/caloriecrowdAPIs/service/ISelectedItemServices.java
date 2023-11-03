package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.entity.SelectedItems;
import com.calorieCrowd.caloriecrowdAPIs.model.CalorieResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.SelectedFoodItems;

import java.util.List;

public interface ISelectedItemServices
{
    public List<SelectedItems> mapSelectedFoodItemsToSelectedItems(List<SelectedFoodItems> listOfSelectedFoodItems);
    public CalorieResponse addSelecteditems(List<SelectedItems>listOfSelectedItems);

}
