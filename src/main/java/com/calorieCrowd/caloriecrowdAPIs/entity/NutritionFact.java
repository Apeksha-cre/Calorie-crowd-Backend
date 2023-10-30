package com.calorieCrowd.caloriecrowdAPIs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "nutrition_facts")
public class NutritionFact
{
    @Id
    @Column
    private Long foodId;

    @Column
    private String foodName;

    @Column
    private String foodCategory;

    @Column
    private Integer calories;

    @Column
    private Double fat;

    @Column
    private Double carbohydrate;

    @Column
    private Double sugar;

    @Column
    private Double fiber;

    @Column
    private Double cholesterolMg;

    @Column
    private Double saturatedFats;

    @Column
    private Double calciumMg;

    @Column
    private Double ironFemg;
    @Column
    private Integer protein;

    @Column
    private Integer netCarbs;

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

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public long getCalorie() {
        return calories;
    }

    public void setCalorie(Integer calorie) {
        this.calories = calorie;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getCholestrerolMg() {
        return cholesterolMg;
    }

    public void setCholestrerolMg(Double cholestrerolMg) {
        this.cholesterolMg = cholestrerolMg;
    }

    public Double getSaturatedFats() {
        return saturatedFats;
    }

    public void setSaturatedFats(Double saturatedFats) {
        this.saturatedFats = saturatedFats;
    }

    public Double getCalciumMg() {
        return calciumMg;
    }

    public void setCalciumMg(Double calciumMg) {
        this.calciumMg = calciumMg;
    }

    public Double getIronFemg() {
        return ironFemg;
    }

    public void setIronFemg(Double ironFemg) {
        this.ironFemg = ironFemg;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getNetCarb() {
        return netCarbs;
    }

    public void setNetCarb(Integer netCarb) {
        this.netCarbs = netCarb;
    }


}
