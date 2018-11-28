package com.urbaniak.krzysztof.webfluxnews.infrastructure

import com.urbaniak.krzysztof.webfluxnews.application.ArticlesService
import com.urbaniak.krzysztof.webfluxnews.application.date.DateFormattingPolicy
import com.urbaniak.krzysztof.webfluxnews.application.date.UtcLocalDateFormattingPolicy
import com.urbaniak.krzysztof.webfluxnews.domain.ArticlesRepository
import com.urbaniak.krzysztof.webfluxnews.newsclient.NewsClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun externalNewsApiRepository(client: NewsClient): ArticlesRepository =
        ExternalNewsApiRepository(client)

    @Bean
    fun dateFormattingPolicy(): DateFormattingPolicy =
        UtcLocalDateFormattingPolicy()

    @Bean
    fun articlesService(repository: ArticlesRepository, dateFormatter: DateFormattingPolicy) =
        ArticlesService(repository, UtcLocalDateFormattingPolicy())

}