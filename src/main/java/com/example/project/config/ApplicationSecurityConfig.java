package com.example.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  AuthenticationProvider authenticationProvider;
  @Autowired
  JwtAuthenticationFilter filter;
  
  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
   
    return super.authenticationManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   
    auth.authenticationProvider(authenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // TODO Auto-generated method stub
    http.authorizeRequests().antMatchers("/register**","/login**").permitAll().anyRequest().authenticated();
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  }
  
}
