package com.urbaniak.krzysztof.webfluxnews.domain

import java.time.Instant

data class Article(
    val sourceName: String,
    val author: String,
    val title: String,
    val description: String,
    val urlToArticle: String,
    val urlToImage: String,
    val publishedAt: Instant?
)