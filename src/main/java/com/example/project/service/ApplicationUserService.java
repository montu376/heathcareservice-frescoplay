package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import org.json.simple.JSONObject;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.security.JwtUtil;
import com.example.project.Model.ApplicationUserDetails;



@Service
public class ApplicationUserService implements  UserDetailsService {
  @Autowired
  ApplicationUserRepository applicationUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub

    Optional<ApplicationUser> user = applicationUserRepository.findUserByUsername(username);
    if(!user.isPresent()){
      throw new UsernameNotFoundException("");
    }
    UserDetails userDetails = new ApplicationUserDetails(user.get());
    return userDetails;
  }


}

