package com.hello.world.controller;

import com.hello.world.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

  @Autowired MockMvc mockMvc;
  @MockBean WelcomeService welcomeService;

  @Test
  void shouldGetTheCounter() throws Exception {

    when(welcomeService.getCounter()).thenReturn("Hello world! 2");
    final var response =
        this.mockMvc
            .perform(get("/api/v1/counter"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

    final var respBody = response.getContentAsString();
    assertThat(respBody).isEqualTo("Hello world! 2");
  }
}
