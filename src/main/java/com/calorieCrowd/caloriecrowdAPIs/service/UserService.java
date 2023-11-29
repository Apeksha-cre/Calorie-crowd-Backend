package com.calorieCrowd.caloriecrowdAPIs.service;

import com.calorieCrowd.caloriecrowdAPIs.entity.User;
import com.calorieCrowd.caloriecrowdAPIs.model.ApiUser;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginResponse;
import com.calorieCrowd.caloriecrowdAPIs.model.LoginUser;
import com.calorieCrowd.caloriecrowdAPIs.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    public ApiUser createUser(ApiUser user){
       User userEntity= mapnewUserToUser(user);
       User createdUser= userRepository.save(userEntity);//to create a new user or to add a new user in table
       ApiUser apiUser=mapUserToApiUser(createdUser);
        return apiUser;
    }

    private User mapnewUserToUser(ApiUser user)
    {
        User newUser=new User();
        newUser.setUserId(user.getUserId());
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setMobileNumber(user.getMobileNumber());
        return newUser;
    }

    private ApiUser mapUserToApiUser(User user)
    {
        ApiUser apiUser=new ApiUser();
            apiUser.setUserId(user.getUserId());
            apiUser.setEmail(user.getEmail());
            apiUser.setMobileNumber(user.getMobileNumber());
            apiUser.setPassword(user.getPassword());
            apiUser.setName(user.getName());
            return apiUser;

    }
    public LoginResponse logInUser(LoginUser loginuser)
    {
        String userId=userRepository.findByEmail(loginuser.getEmail(), loginuser.getPassword());
        LoginResponse loginresponse = new LoginResponse();
        if(userId== null)
        {
            String loginMessage="User not found...";
            loginresponse.setLoginMessage(loginMessage);
        }
        else {
            User loggedUser = userRepository.findByUserId(userId);
            String loginMessage = "Logged in....";
            loginresponse.setLoginMessage(loginMessage);
            loginresponse.setUser(loggedUser);
        }
        return loginresponse;
    }

}
