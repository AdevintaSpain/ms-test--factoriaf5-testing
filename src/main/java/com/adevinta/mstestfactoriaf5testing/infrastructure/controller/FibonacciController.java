package com.adevinta.mstestfactoriaf5testing.infrastructure.controller;

import com.adevinta.mstestfactoriaf5testing.domain.FibonacciAdder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

  private final FibonacciAdder fibonacciAdder;

  public FibonacciController(FibonacciAdder fibonacciAdder) {
    this.fibonacciAdder = fibonacciAdder;
  }

  @GetMapping("/fibonacci/{number}")
  public String get(@PathVariable("number") long number) {
    return String.valueOf(fibonacciAdder.add(number));
  }
}
