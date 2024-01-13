package com.caloriecrowd.model;

public class ApiUser {


    private String userId;

    private String name;

    private String email;

    private  String password;

   private String goalCalorie;

   private String weight;
    private  long mobileNumber;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGoalCalorie() {
        return goalCalorie;
    }

    public void setGoalCalorie(String goalCalorie) {
        this.goalCalorie = goalCalorie;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



}
