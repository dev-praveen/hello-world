package com.hello.world.controller;

import com.hello.world.service.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HelloWorldController {

  private final WelcomeService welcomeService;

  @GetMapping("/counter")
  public ResponseEntity<String> hello() {

    final var counterMsg = welcomeService.getCounter();
    return ResponseEntity.ok(counterMsg);
  }
}
