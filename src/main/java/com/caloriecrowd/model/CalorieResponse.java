package com.caloriecrowd.model;

public class CalorieResponse {
    public Integer totalProtein;
    public Integer totalCarb;
    private Integer totalCalorie;

    public Integer getTotalCalorie() {
        return totalCalorie;
    }

    public void setTotalCalorie(Integer totalCalorie) {
        this.totalCalorie = totalCalorie;
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
}
