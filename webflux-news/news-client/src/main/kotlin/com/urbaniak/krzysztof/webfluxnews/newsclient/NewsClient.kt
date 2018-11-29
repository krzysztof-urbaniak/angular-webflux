package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.client.WebClient


class NewsClient(private val uriAssembler: UriAssembler) {
    private val client = WebClient.create()

    fun getNews(category: String, country: String) =
        client
            .get()
            .uri(uriAssembler.createUri(category, country))
            .accept(APPLICATION_JSON)
            .retrieve()
            .bodyToMono(NewsResponse::class.java)

}

class ApiKeyNotProvidedException : RuntimeException()

class NewsClientProperties {
    var scheme: String? = null
    var host: String? = null
    var apiKey: String? = null

}
