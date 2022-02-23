package com.adevinta.mstestfactoriaf5testing.domain;

public class FibonacciAdder {

  private final FibonacciList fibonacciList;

  public FibonacciAdder(FibonacciList fibonacciList) {
    this.fibonacciList = fibonacciList;
  }

  public long add(long number) {
    var list = fibonacciList.get(number);
    var sum = 0L;
    for (long elem : list) {
      sum += elem;
    }
    return sum;
  }

  // Other implementations (not used)

  private long otherImplementation_Using_Streams(long number) {
    return fibonacciList.get(number).stream()
          .reduce(0L, Long::sum);
  }

  private long otherImplementation_Using_ForLoop(long number) {
    var list = fibonacciList.get(number);
    var sum = 0L;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    return sum;
  }
}
