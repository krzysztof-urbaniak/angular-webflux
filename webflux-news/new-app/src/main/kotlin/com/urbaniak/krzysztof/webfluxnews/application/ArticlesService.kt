package com.urbaniak.krzysztof.webfluxnews.application

import com.urbaniak.krzysztof.webfluxnews.application.date.DateFormattingPolicy
import com.urbaniak.krzysztof.webfluxnews.application.dto.ArticleDto
import com.urbaniak.krzysztof.webfluxnews.application.dto.NewsDto
import com.urbaniak.krzysztof.webfluxnews.domain.ArticlesRepository
import reactor.core.publisher.Flux


class ArticlesService(
    private val repository: ArticlesRepository,
    private val dateFormatter: DateFormattingPolicy
) {

    fun getArticles(country: String, category: String): Flux<NewsDto> =
        repository.getArticles(country, category)
            .map { article ->
                NewsDto(
                    country = country,
                    category = category,
                    article = ArticleDto(
                        author = article.author,
                        title = article.title,
                        description = article.description,
                        date = article.publishedAt?.let { dateFormatter.format(it) } ?: "",
                        sourceName = article.sourceName,
                        articleUrl = article.urlToArticle,
                        imageUrl = article.urlToImage
                    )
                )
            }

}