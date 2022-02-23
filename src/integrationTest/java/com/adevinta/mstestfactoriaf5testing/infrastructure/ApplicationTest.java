package com.adevinta.mstestfactoriaf5testing.infrastructure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.TEXT;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(
      classes = {Application.class},
      properties = {"spring.profiles.active=integration-test"},
      webEnvironment = RANDOM_PORT
)
class ApplicationTest {

  @Value("http://localhost:${local.server.port}")
  private String url;

  @ParameterizedTest
  @CsvSource({
        "0, 0",
        "1, 0",
        "2, 1",
        "3, 2",
        "4, 4",
        "5, 7",
        "10, 88"
  })
  void shouldReturnFibonacciSums(long number, String expectedBody) {
    given()
          .when()
          .get(url + "/fibonacci/{number}", number)
          .then()
          .statusCode(OK.value())
          .contentType(TEXT)
          .body(equalTo(expectedBody));
  }
}
