package com.urbaniak.krzysztof.webfluxnews

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxNewsApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<WebfluxNewsApplication>(*args)
        }
    }
}
