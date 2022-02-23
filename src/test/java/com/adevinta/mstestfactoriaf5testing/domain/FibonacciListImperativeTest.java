package com.adevinta.mstestfactoriaf5testing.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class FibonacciListImperativeTest {

  @ParameterizedTest
  @MethodSource("shouldGetFibonacciListTestCases")
  void shouldGetFibonacciList(long number, List<Long> expectedResult) {
    var fibonacciList = new FibonacciListImperative();
    assertThat(fibonacciList.get(number))
          .isEqualTo(expectedResult);
  }

  public static Stream<Arguments> shouldGetFibonacciListTestCases() {
    return Stream.of(
          Arguments.of(0L, emptyList()),
          Arguments.of(1L, List.of(0L)),
          Arguments.of(2L, List.of(0L, 1L)),
          Arguments.of(3L, List.of(0L, 1L, 1L)),
          Arguments.of(4L, List.of(0L, 1L, 1L, 2L)),
          Arguments.of(5L, List.of(0L, 1L, 1L, 2L, 3L)),
          Arguments.of(10L, List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L))
    );
  }
}
