import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  id("org.springframework.boot") version "2.6.3"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("org.unbroken-dome.test-sets") version "4.0.0"
  kotlin("jvm") version "1.6.10"
  kotlin("plugin.spring") version "1.6.10"
  id("idea")
}

group = "com.adevinta.factoriaf5"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

extra["springCloudVersion"] = "2021.0.1"

repositories {
  mavenCentral()
}

testSets {
  create("integrationTest") {}
}

dependencies {
  // Spring
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-security")

  // Kotlin
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  // Test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.mockito:mockito-inline:4.2.0")
  testImplementation("org.mockito:mockito-junit-jupiter:4.2.0")
  testImplementation("org.assertj:assertj-core:3.22.0")
  testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.6.0")
  testImplementation("com.nhaarman:mockito-kotlin:1.6.0")

  // Integration Test
  "integrationTestImplementation"("io.rest-assured:rest-assured:4.5.1")
  "integrationTestImplementation"("io.rest-assured:rest-assured-all:4.5.1")
  "integrationTestImplementation"("org.testcontainers:testcontainers:1.16.3")
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events(PASSED, SKIPPED, FAILED)
    exceptionFormat = FULL
    showExceptions = true
    showCauses = true
    showStackTraces = true
  }
}

tasks["check"].dependsOn("integrationTest")
tasks["integrationTest"].shouldRunAfter("test")
