package io.helpermethod.jpa.performance

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaPerformanceApplication

fun main(args: Array<String>) {
	runApplication<JpaPerformanceApplication>(*args)
}
