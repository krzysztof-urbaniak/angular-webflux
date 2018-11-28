package com.urbaniak.krzysztof.webfluxnews.infrastructure

import com.urbaniak.krzysztof.webfluxnews.application.ArticleDto
import com.urbaniak.krzysztof.webfluxnews.application.NewsDto
import org.springframework.stereotype.Repository

@Repository
class InMemoryNewsRepository {
    fun getArticles(country: String, category: String) =
        NewsDto(
            country = country,
            category = category,
            article = ArticleDto(
                author = "Marek",
                title = "New car",
                description = "sggsgsgs",
                date = "2001-04-22",
                sourceName = "sfsf",
                articleUrl = "http://example.com",
                imageUrl = "http://example.image.com"
            )

        )
}