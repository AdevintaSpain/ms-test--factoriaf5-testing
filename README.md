[![CI](https://github.com/AdevintaSpain/ms-test--factoriaf5-testing/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/AdevintaSpain/ms-test--factoriaf5-testing/actions/workflows/gradle.yml)

# ms-test--factoriaf5-testing

🏫 Testing Workshop for Factoria F5

Sample used in Adevinta Spain's [Factoria F5](https://factoriaf5.org/) masterclasses

## Develop

* Clone/fork this repo or create your own using [spring initializr](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.6.3&packaging=jar&jvmVersion=11&groupId=com.adevinta.factoriaf5&artifactId=Testing&name=Testing&description=Testing%20demo%20for%20FactoriaF5&packageName=com.adevinta.mstestfactoriaf5testing&dependencies=cloud-config-client)
* [Setup Continuous Integration using Github Actions](.github/workflows/gradle.yml)

Review the implementation:
* [FibonacciController](src/main/java/com/adevinta/mstestfactoriaf5testing/infrastructure/controller/FibonacciController.java) => [FibonacciAdder](src/main/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciAdder.java) => [FibonacciList](src/main/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciList.java) ( [FibonacciListFunctional](src/main/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciListFunctional.java) or [FibonacciListImperative](src/main/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciListImperative.java) )
* [FibonacciConfiguration](src/main/java/com/adevinta/mstestfactoriaf5testing/infrastructure/configuration/FibonacciConfiguration.java)

Review the unit tests:
* [FibonacciControllerTest](src/test/java/com/adevinta/mstestfactoriaf5testing/infrastructure/controller/FibonacciControllerTest.java)
* [FibonacciAdderTest](src/test/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciAdderTest.java)
* [FibonacciListFunctionalTest](src/test/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciListFunctionalTest.java)
* [FibonacciListImperativeTest](src/test/java/com/adevinta/mstestfactoriaf5testing/domain/FibonacciListImperativeTest.java)

Review the integration test:
* [ApplicationTest](src/integrationTest/java/com/adevinta/mstestfactoriaf5testing/infrastructure/ApplicationTest.java)

## Run

```
./gradlew bootRun
```

And open [http://localhost:8000/fibonacci/10](http://localhost:8000/fibonacci/10) in a browser or execute:
```
curl http://localhost:8000/fibonacci/10
```

## Test

```
./gradlew test
```

## Integration Test

```
./gradlew integrationTest
```

## Tools

* [IntelliJ Idea](https://www.jetbrains.com/idea/) or any other IDE you like
* Any [OpenJDK Java 11](https://en.wikipedia.org/wiki/OpenJDK) like [Adoptium](https://adoptium.net/)
