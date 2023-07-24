package com.example.project.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class ApplicationAuthEntryPoint implements AuthenticationEntryPoint{

  @Override
  public void commence(HttpServletRequest arg0,
   HttpServletResponse response,
   AuthenticationException exception)
      throws IOException, ServletException {

    

    
  }
  
}
