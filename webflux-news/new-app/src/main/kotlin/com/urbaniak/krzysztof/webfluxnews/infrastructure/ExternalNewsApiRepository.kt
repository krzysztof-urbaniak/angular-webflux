package com.urbaniak.krzysztof.webfluxnews.infrastructure

import com.urbaniak.krzysztof.webfluxnews.domain.Article
import com.urbaniak.krzysztof.webfluxnews.domain.ArticlesRepository
import com.urbaniak.krzysztof.webfluxnews.newsclient.NewsClient
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import java.time.Instant


class ExternalNewsApiRepository(private val client: NewsClient): ArticlesRepository {

    override fun getArticles(country: String, category: String): Flux<Article> {
        return client
            .getNews(category, country)
            .toFlux()
            .flatMap { newsResponse -> Flux.fromIterable(newsResponse.articles) }
            .map { article ->
                Article(
                    sourceName = article.source?.name ?: "",
                    author = article.author ?: "",
                    title = article.title ?: "",
                    description = article.description ?: "",
                    urlToArticle = article.url ?: "",
                    urlToImage = article.urlToImage ?: "",
                    publishedAt = Instant.parse(article.publishedAt)
                )
            }
    }
}