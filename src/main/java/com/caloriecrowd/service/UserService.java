package com.caloriecrowd.service;

import com.caloriecrowd.entity.UserEntity;
import com.caloriecrowd.model.ApiUser;
import com.caloriecrowd.model.LoginResponse;
import com.caloriecrowd.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {
  @Autowired UserRepository userRepository;

  public ApiUser createUser(ApiUser user) {
    UserEntity userEntity = mapApiUserToUserEntity(user);
    UserEntity createdUserEntity =
        userRepository.save(userEntity); // to create a new user or to add a new user in table
    ApiUser apiUser = mapUserEntityToApiUser(createdUserEntity);
    return apiUser;
  }

  private UserEntity mapApiUserToUserEntity(ApiUser user) {
    UserEntity newUserEntity = new UserEntity();
    newUserEntity.setUserId(user.getUserId());
    newUserEntity.setEmail(user.getEmail());
    newUserEntity.setName(user.getName());
    newUserEntity.setPassword(user.getPassword());
    newUserEntity.setMobileNumber(user.getMobileNumber());
    newUserEntity.setGoalCalorie(user.getGoalCalorie());
    newUserEntity.setWeight(user.getWeight());
    return newUserEntity;
  }

  private ApiUser mapUserEntityToApiUser(UserEntity userEntity) {
    ApiUser apiUser = new ApiUser();
    apiUser.setUserId(userEntity.getUserId());
    apiUser.setEmail(userEntity.getEmail());
    apiUser.setMobileNumber(userEntity.getMobileNumber());
    apiUser.setPassword(userEntity.getPassword());
    apiUser.setName(userEntity.getName());
    apiUser.setGoalCalorie(userEntity.getGoalCalorie());
    apiUser.setWeight(userEntity.getWeight());
    return apiUser;
  }

  public LoginResponse logInUser(ApiUser loginuser) {
    String userId = userRepository.findByEmail(loginuser.getEmail(), loginuser.getPassword());
    LoginResponse loginresponse = new LoginResponse();
    if (userId == null) {
      String loginMessage = "User not found...";
      loginresponse.setLoginMessage(loginMessage);
    } else {
      UserEntity loggedUserEntity = userRepository.findByUserId(userId);
      String loginMessage = "Logged in....";
      loginresponse.setLoginMessage(loginMessage);
      loginresponse.setUser(loggedUserEntity);
    }
    return loginresponse;
  }
}
