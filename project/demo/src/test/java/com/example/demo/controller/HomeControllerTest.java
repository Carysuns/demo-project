package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class HomeControllerTest {

  private String targetUri = "/test1";

  @BeforeEach
  void setup() {


  }

  @Test
  public void testOk() throws Exception {

    System.out.println("1");
  }
}
