package com.caloriecrowd.model;

public class NutritionDetails {
  private long foodId;
  private String foodName;
  private String foodCategory;
  private long calorie;
  private long protein;
  private long netCarb;

  public long getFoodId() {
    return foodId;
  }

  public void setFoodId(long foodId) {
    this.foodId = foodId;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public String getFoodCategory() {
    return foodCategory;
  }

  public void setFoodCategory(String foodCategory) {
    this.foodCategory = foodCategory;
  }

  public long getCalorie() {
    return calorie;
  }

  public void setCalorie(long calorie) {
    this.calorie = calorie;
  }

  public long getProtein() {
    return protein;
  }

  public void setProtein(long protein) {
    this.protein = protein;
  }

  public long getNetCarb() {
    return netCarb;
  }

  public void setNetCarb(long netCarb) {
    this.netCarb = netCarb;
  }
}
