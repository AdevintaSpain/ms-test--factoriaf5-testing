package com.adevinta.mstestfactoriaf5testing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    doReturn(asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L))
          .when(fibonacciList).get(number);

    var fibonacciAdder = new FibonacciAdder();
    assertThat(fibonacciAdder.add(number))
          .isEqualTo(143L);
  }
}
