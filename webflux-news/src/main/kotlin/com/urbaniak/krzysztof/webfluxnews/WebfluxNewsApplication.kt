package com.urbaniak.krzysztof.webfluxnews

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class WebfluxNewsApplication

fun main(args: Array<String>) {
    runApplication<WebfluxNewsApplication>(*args)
}
