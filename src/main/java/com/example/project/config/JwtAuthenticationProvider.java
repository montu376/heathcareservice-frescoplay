package com.example.project.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.project.Model.ApplicationUser;

@Component
public class JwtAuthenticationProvider  implements AuthenticationProvider{
  @Autowired
  UserDetailsService userDetailsService;
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // TODO Auto-generated method stub

    JwtAuthtication jwtAuthtication = (JwtAuthtication)authentication;

    UserDetails user = userDetailsService.loadUserByUsername(authentication.getName());

    if(!authentication.getCredentials().toString().equals(user.getPassword())){
      authentication.setAuthenticated(false);
    }

    jwtAuthtication.setUserId(user.getUsername());
  
    return jwtAuthtication;
  }

  @Override
  public boolean supports(Class<?> authenticationType) {
    // TODO Auto-generated method stub
    return authenticationType.equals(JwtAuthtication.class);
  }
  
}
