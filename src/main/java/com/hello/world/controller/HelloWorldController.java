package com.hello.world.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

  private int counter = 0;

  @GetMapping("/counter")
  public ResponseEntity<String> hello() {

    counter++;
    final var counterMsg = "Hello world! " + counter;
    return ResponseEntity.ok(counterMsg);
  }
}
