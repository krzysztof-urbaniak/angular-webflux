package com.urbaniak.krzysztof.webfluxnews.application

import com.urbaniak.krzysztof.webfluxnews.domain.ArticlesRepository
import reactor.core.publisher.Flux


class ArticlesService(val repository: ArticlesRepository) {

    fun getArticles(country: String, category: String): Flux<NewsDto> =
        repository.getArticles(country, category)
            .map {
                NewsDto(
                    country = country,
                    category = category,
                    article = ArticleDto(
                        author = it.author,
                        title = it.title,
                        description = it.description,
                        date = "",
                        sourceName = it.sourceName,
                        articleUrl = it.urlToArticle,
                        imageUrl = it.urlToImage
                    )
                )
            }

}