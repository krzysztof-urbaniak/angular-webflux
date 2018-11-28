package com.urbaniak.krzysztof.webfluxnews.domain

import reactor.core.publisher.Flux


interface ArticlesRepository {
    fun getArticles(country: String, category: String): Flux<Article>
}