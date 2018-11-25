package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import java.net.URI


class NewsClient {
    private val client = WebClient.create()

    fun getNews(category: String, country: String) =
        client
            .get()
            .uri(createUri(category, country))
            .accept(APPLICATION_JSON)
            .exchange()
            .flatMap { response -> response.bodyToMono(NewsResponse::class.java) }

    private fun createUri(category: String, country: String): (UriBuilder) -> URI {
        return { builder ->
            builder.scheme("http")//"https")
                .host("localhost:8202")//"newsapi.org")
                .path(PATH)
                .queryParams(
                    toMultiValueMap(
                        "country" to country,
                        "category" to category,
                        "apiKey" to "secretKey"//API_KEY
                    )
                )
                .build()
        }
    }

    companion object {
        private val PATH = "v2/top-headlines"
        private val API_KEY = "8ede0263f6504149b1d5e9ede2954b4c"

        @JvmStatic
        fun toMultiValueMap(vararg pairs: Pair<String, String>): MultiValueMap<String, String> =
            LinkedMultiValueMap(
                pairs.map {
                    it.first to mutableListOf(it.second)
                }.toMap()
            )

    }


}