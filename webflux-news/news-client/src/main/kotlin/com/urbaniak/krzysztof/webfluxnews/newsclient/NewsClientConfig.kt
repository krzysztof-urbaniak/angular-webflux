package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableConfigurationProperties
@Configuration
internal class NewsClientConfig {

    @Bean
    @ConfigurationProperties(prefix = "news-client")
    fun notificationsTwoProperties() =
        NewsClientProperties()

    @Bean
    fun newsClient(properties: NewsClientProperties) =
        NewsClient(properties)
}

class NewsClientProperties {
    var scheme: String? = null
    var host: String? = null
    var apiKey: String? = null
}