package com.calorieCrowd.caloriecrowdAPIs.model;

public class SelectedFoodItems
{
    //private String enteryId;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private Long foodId;
    private String foodName;
    private String foodQuantity;
    private Integer calories;
    private Integer totalCalorie;
    private Integer protein;
    private Integer carb;
    private Integer totalCarb;
    private  Integer totalProtein;

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCarb() {
        return carb;
    }

    public void setCarb(Integer carb) {
        this.carb = carb;
    }

    public Integer getTotalCarb() {
        return totalCarb;
    }

    public void setTotalCarb(Integer totalCarb) {
        this.totalCarb = totalCarb;
    }

    public Integer getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(Integer totalProtein) {
        this.totalProtein = totalProtein;
    }
//    public String getEnteryId() {
//        return enteryId;
//    }
//
//    public void setEnteryId(String enteryId) {
//        this.enteryId = enteryId;
//    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getTotalCalorie() {
        return totalCalorie;
    }

    public void setTotalCalorie(Integer totalCalorie) {
        this.totalCalorie = totalCalorie;
    }
}
