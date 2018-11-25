package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NewsClientConfig {

    @Bean
    fun newsClient() =
        NewsClient()

}