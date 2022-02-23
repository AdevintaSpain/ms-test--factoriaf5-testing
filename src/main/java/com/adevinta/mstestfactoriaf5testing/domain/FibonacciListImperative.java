package com.adevinta.mstestfactoriaf5testing.domain;

import java.util.ArrayList;
import java.util.List;

public class FibonacciListImperative implements FibonacciList {

  @Override
  public List<Long> get(long number) {
    if (number == 0L) {
      return List.of();
    } else if (number == 1L) {
      return List.of(0L);
    } else {
      var result = new ArrayList<Long>();
      result.add(0L);
      result.add(1L);
      for (int i = 2; i < number; i++) {
        result.add(result.get(i - 2) + result.get(i - 1));
      }
      return result;
    }
  }
}
