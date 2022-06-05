package com.hello.world.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

  private int counter = 0;

  public String getCounter() {

    counter++;
    return "Hello world! " + counter;
  }
}
