package com.adevinta.mstestfactoriaf5testing.domain;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class FibonacciListFunctional implements FibonacciList {

  @Override
  public List<Long> get(long number) {
    return FibonacciGenerator.generator()
          .limit(number)
          .boxed()
          .collect(toList());
  }

  private static class FibonacciGenerator {
    private long n1 = -1L;
    private long n2 = -1L;

    public long next() {
      if (n1 == -1L && n2 == -1L) {
        n2 = 0L;
        return 0L;
      }
      if (n1 == -1L && n2 == 0L) {
        n1 = 1L;
        return 1L;
      } else {
        var result = n1 + n2;
        n2 = n1;
        n1 = result;
        return result;
      }
    }

    public static LongStream generator() {
      var generator = new FibonacciGenerator();
      return LongStream.generate(generator::next);
    }
  }
}
