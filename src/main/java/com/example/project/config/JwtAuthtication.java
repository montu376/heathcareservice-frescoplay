package com.example.project.config;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthtication extends UsernamePasswordAuthenticationToken{

  public JwtAuthtication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    super(principal, credentials, authorities);
  }
  

  public JwtAuthtication(Object principal, Object credentials) {
    super(principal, credentials);
    //TODO Auto-generated constructor stub
  }
  
}
