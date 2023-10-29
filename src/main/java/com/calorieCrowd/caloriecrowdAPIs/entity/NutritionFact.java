package com.calorieCrowd.caloriecrowdAPIs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class NutritionFact
{
    @Id
    @Column
    private long foodId;

    @Column
    private String foodName;

    @Column
    private String foodCategory;

    @Column
    private long calorie;

    @Column
    private double fat;

    @Column
    private double carbohydrate;

    @Column
    private double sugar;

    @Column
    private double fiber;

    @Column
    private double cholestrerolMg;

    @Column
    private double saturatedFats;

    @Column
    private double calciumMg;

    @Column
    private double ironFemg;
    @Column
    private long protein;

    @Column
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

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getCholestrerolMg() {
        return cholestrerolMg;
    }

    public void setCholestrerolMg(double cholestrerolMg) {
        this.cholestrerolMg = cholestrerolMg;
    }

    public double getSaturatedFats() {
        return saturatedFats;
    }

    public void setSaturatedFats(double saturatedFats) {
        this.saturatedFats = saturatedFats;
    }

    public double getCalciumMg() {
        return calciumMg;
    }

    public void setCalciumMg(double calciumMg) {
        this.calciumMg = calciumMg;
    }

    public double getIronFemg() {
        return ironFemg;
    }

    public void setIronFemg(double ironFemg) {
        this.ironFemg = ironFemg;
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
