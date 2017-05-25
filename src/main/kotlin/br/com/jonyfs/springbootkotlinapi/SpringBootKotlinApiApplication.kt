package br.com.jonyfs.springbootkotlinapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootKotlinApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinApiApplication::class.java, *args)
}
