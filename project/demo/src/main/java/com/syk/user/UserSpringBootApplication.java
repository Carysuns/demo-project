package com.syk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class UserSpringBootApplication {

  public static void main(String[] args) {
    
    SpringApplication.run(UserSpringBootApplication.class, args);
  }
}
