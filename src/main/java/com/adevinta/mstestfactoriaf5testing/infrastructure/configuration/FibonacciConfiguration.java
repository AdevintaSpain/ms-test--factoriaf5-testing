package com.adevinta.mstestfactoriaf5testing.infrastructure.configuration;

import com.adevinta.mstestfactoriaf5testing.domain.FibonacciAdder;
import com.adevinta.mstestfactoriaf5testing.domain.FibonacciList;
import com.adevinta.mstestfactoriaf5testing.domain.FibonacciListFunctional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FibonacciConfiguration {

  @Bean
  public FibonacciList fibonacciList() {
    return new FibonacciListFunctional();
  }

  @Bean
  public FibonacciAdder fibonacciAdder(FibonacciList fibonacciList) {
    return new FibonacciAdder(fibonacciList);
  }
}
