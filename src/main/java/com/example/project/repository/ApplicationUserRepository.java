package com.example.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project.Model.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository  extends JpaRepository<ApplicationUser, String>{


  @Query(value="SELECT * FROM APPLICATIONUSER AS AU WHERE AU.user_email = ?1",nativeQuery = true)
  public Optional<ApplicationUser> findUserByUsername(String username);

}
