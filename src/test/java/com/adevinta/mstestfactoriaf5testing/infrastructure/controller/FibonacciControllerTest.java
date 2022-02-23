package com.adevinta.mstestfactoriaf5testing.infrastructure.controller;

import com.adevinta.mstestfactoriaf5testing.domain.FibonacciAdder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FibonacciController.class)
class FibonacciControllerTest {

  @Autowired MockMvc mockMvc;
  @MockBean FibonacciAdder fibonacciAdder;

  @Test
  void shouldAddFibonacciNumbers() throws Exception {
    var number = 10L;
    var result = 143L;
    doReturn(result).when(fibonacciAdder).add(number);

    mockMvc.perform(get("/fibonacci/" + number))
          .andExpect(status().isOk())
          .andExpect(content().string(String.valueOf(result)));

    verify(fibonacciAdder).add(number);
  }
}
