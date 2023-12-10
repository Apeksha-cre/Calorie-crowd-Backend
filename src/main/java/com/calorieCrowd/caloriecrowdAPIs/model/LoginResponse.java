package com.calorieCrowd.caloriecrowdAPIs.model;

import com.calorieCrowd.caloriecrowdAPIs.entity.User;

public class LoginResponse
{
    private User user;
    private String loginMessage;

    private String bearerToken;

    private long ttl;
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


    public String getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

}
