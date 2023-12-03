package com.calorieCrowd.caloriecrowdAPIs.model;

public class CalorieResponse {

    private Integer totalCalorie;

    public Integer getTotalCalorie() {
        return totalCalorie;
    }

    public Integer totalProtein;

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

    public Integer totalCarb;

    public void setTotalCalorie(Integer totalCalorie) {
        this.totalCalorie = totalCalorie;
    }
}
