package com.example.springDemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
	SpringApplication.run(SpringDemoApplication::class.java, *args)
}
