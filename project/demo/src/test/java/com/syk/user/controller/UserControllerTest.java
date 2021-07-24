package com.syk.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.syk.user.controller.user.UserController;
import com.syk.user.openapi.model.UserResultModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UserControllerTest {

  @Autowired
  private UserController userController;

  @BeforeEach
  void setup() {


  }

  @Test
  public void testOk() throws Exception {

    ResponseEntity<UserResultModel> user = userController.findById(1);

    assertEquals("孙永科", user.getBody().getUserName());
    assertEquals("鞍山", user.getBody().getAddress());
  }
}
