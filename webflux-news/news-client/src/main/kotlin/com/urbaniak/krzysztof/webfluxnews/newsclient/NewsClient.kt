package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import java.net.URI


class NewsClient(private val properties: NewsClientProperties) {
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
            builder.scheme(properties.scheme)
                .host(properties.host)
                .path(PATH)
                .queryParams(
                    toMultiValueMap(
                        "country" to country,
                        "category" to category,
                        "apiKey" to (properties.apiKey ?: throw ApiKeyNotProvidedException())
                    )
                )
                .build()
        }
    }

    companion object {
        private const val PATH = "v2/top-headlines"

        @JvmStatic
        fun toMultiValueMap(vararg pairs: Pair<String, String>): MultiValueMap<String, String> =
            LinkedMultiValueMap(
                pairs.map {
                    it.first to mutableListOf(it.second)
                }.toMap()
            )

    }

}

class NewsClientProperties {
    var scheme: String? = null
    var host: String? = null
    var apiKey: String? = null
}

class ApiKeyNotProvidedException : RuntimeException()
