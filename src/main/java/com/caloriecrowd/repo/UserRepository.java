package com.caloriecrowd.repo;

import com.caloriecrowd.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, String> {

  @Query("SELECT userId FROM User u WHERE u.email= :email AND u.password=:password")
  public String findByEmail(@Param("email") String email, @Param("password") String password);

  @Query("SELECT u FROM User u WHERE u.userId=:userId")
  public UserEntity findByUserId(@Param("userId") String userId);
}
