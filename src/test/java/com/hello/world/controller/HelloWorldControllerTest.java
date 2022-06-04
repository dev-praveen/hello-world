package com.hello.world.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

  @Autowired MockMvc mockMvc;

  @Test
  void shouldGetTheCounter() throws Exception {

    final var response =
        this.mockMvc
            .perform(get("/api/v1/counter"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    final var respBody = response.getContentAsString();
    assertThat(respBody).isEqualTo("Hello world! 1");
  }
}
