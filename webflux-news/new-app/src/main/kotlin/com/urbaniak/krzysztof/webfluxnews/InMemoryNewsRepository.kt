package com.urbaniak.krzysztof.webfluxnews

import org.springframework.stereotype.Repository

@Repository
class InMemoryNewsRepository {
    fun getArticles(country: String, category: String) =
        NewsDto(
            country = country,
            category = category,
            articles = listOf(
                ArticleDto(
                    author = "Marek",
                    title = "New car",
                    description = "sggsgsgs",
                    date = "2001-04-22",
                    sourceName = "sfsf",
                    articleUrl = "http://example.com",
                    imageUrl = "http://example.image.com"
                )
            )
        )
}