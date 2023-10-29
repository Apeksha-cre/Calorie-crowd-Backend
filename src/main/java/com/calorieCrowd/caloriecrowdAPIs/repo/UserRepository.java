package com.calorieCrowd.caloriecrowdAPIs.repo;

import com.calorieCrowd.caloriecrowdAPIs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT userId FROM User u WHERE u.email= :email AND u.password=:password")
    public String findByEmail(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.userId=:userId")
    public User findByUserId(@Param("userId") String userId);

}
