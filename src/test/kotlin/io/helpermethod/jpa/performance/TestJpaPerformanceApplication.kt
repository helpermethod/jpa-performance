package io.helpermethod.jpa.performance

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
	fromApplication<JpaPerformanceApplication>().with(TestcontainersConfiguration::class).run(*args)
}
