package com.adevinta.mstestfactoriaf5testing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FibonacciAdderTest {

  @Mock FibonacciList fibonacciList;

  @Test
  void shouldAddFibonacciNumbers() {
    var number = 10L;
    doReturn(asList(1L, 2L, 3L, 4L))
          .when(fibonacciList).get(number);

    var fibonacciAdder = new FibonacciAdder(fibonacciList);
    assertThat(fibonacciAdder.add(number))
          .isEqualTo(10L);
  }
}
