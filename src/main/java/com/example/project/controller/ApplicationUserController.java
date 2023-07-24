package com.example.project.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.ApplicationUser;
import com.example.project.config.JwtAuthtication;


@RestController
public class ApplicationUserController {

  @Autowired
  AuthenticationManager authenticationManager;

  @PostMapping("/register")
  public ResponseEntity login(@RequestBody ApplicationUser userDto ){

    Authentication authentication = new JwtAuthtication(userDto.getUser_email(), userDto.getPassword(), null);

    authentication = (JwtAuthtication)  authenticationManager.authenticate(authentication);

    HashMap<String ,Object> result = new HashMap<>();

    if(!authentication.isAuthenticated()){
      result.put("message", "Password or username policy failed");
      return ResponseEntity.ok(result);
    }
    result.put("message","Authentication successful!");
    result.put("token","Authentication successful!");
    result.put("id",authentication.get);


    return ResponseEntity.ok(result);

  }

}
