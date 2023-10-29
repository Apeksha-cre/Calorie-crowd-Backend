package com.calorieCrowd.caloriecrowdAPIs.model;

import com.calorieCrowd.caloriecrowdAPIs.entity.User;

public class LoginResponse
{
    private User user;
    private String loginMessage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }


}
