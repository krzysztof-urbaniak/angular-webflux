package com.urbaniak.krzysztof.webfluxnews.newsclient


data class NewsResponse(
    val status: String?,
    val code: String?,
    val error: String?,
    val articles: List<Article>
)

data class Article(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?
)

data class Source(
    val name: String?
)