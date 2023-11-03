package com.calorieCrowd.caloriecrowdAPIs.entity;

import jakarta.persistence.*;


@Entity
public class SelectedItems {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private String enteryId;

    @Column
    private Long foodId;

    @Column
    private String foodName;

    @Column
    private String foodQuantity;

    @Column
    private Integer calories;

    @Column
    private Integer totalCalorie;

    @Column
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnteryId() {
        return enteryId;
    }

    public void setEnteryId(String enteryId) {
        this.enteryId = enteryId;
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
}
