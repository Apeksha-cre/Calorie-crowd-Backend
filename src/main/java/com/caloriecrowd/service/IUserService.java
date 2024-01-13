package com.caloriecrowd.service;

import com.caloriecrowd.model.ApiUser;
import com.caloriecrowd.model.LoginResponse;

public interface IUserService {

  public ApiUser createUser(ApiUser user);

  public LoginResponse logInUser(ApiUser loginUser);
}
