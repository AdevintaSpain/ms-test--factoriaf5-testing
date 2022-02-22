package com.adevinta.mstestfactoriaf5testing.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = [
    "com.adevinta.mstestfactoriaf5testing.infrastructure.controller",
    "com.adevinta.mstestfactoriaf5testing.infrastructure.configuration"
  ]
)
class Application

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
