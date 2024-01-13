package com.caloriecrowd.entity;

import jakarta.persistence.*;

@Entity
public class SelectedItemEntity {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.UUID)
  private String entryId;

  @Column private String userId;

  @Column private Long foodId;

  @Column private String foodName;

  @Column private String foodQuantity;

  @Column private Integer calories;

  @Column private Integer totalCalorie;

  @Column private String date;

  @Column private Integer protein;
  @Column private Integer carb;

  @Column private Integer totalProtein;

  @Column private Integer totalCarb;

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

  public Integer getTotalProtein() {
    return totalProtein;
  }

  public void setTotalProtein(Integer totalProtein) {
    this.totalProtein = totalProtein;
  }

  public Integer getTotalCarb() {
    return totalCarb;
  }

  public void setTotalCarb(Integer totalCarb) {
    this.totalCarb = totalCarb;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getEntryId() {
    return entryId;
  }

  public void setEntryId(String enteryId) {
    this.entryId = enteryId;
  }

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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
