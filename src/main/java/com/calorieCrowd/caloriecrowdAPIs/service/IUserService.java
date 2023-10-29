package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.model.ApiUser;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginUser;

public interface IUserService {

    public ApiUser createUser(ApiUser user);
    public LoginResponse logInUser(LoginUser loginuser);
}
