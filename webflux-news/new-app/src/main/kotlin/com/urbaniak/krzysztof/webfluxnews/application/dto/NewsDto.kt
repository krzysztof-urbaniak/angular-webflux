package com.urbaniak.krzysztof.webfluxnews.application.dto

data class NewsDto(
    val country: String,
    val category: String,
    val article: ArticleDto
)

data class ArticleDto(
    val author: String,
    val title: String,
    val description: String,
    val date: String,
    val sourceName: String,
    val articleUrl: String,
    val imageUrl: String
)