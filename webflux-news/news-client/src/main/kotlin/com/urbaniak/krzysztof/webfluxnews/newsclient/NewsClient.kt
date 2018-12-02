package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono


class NewsClient(private val uriAssembler: UriAssembler) {
    private val client = WebClient.create()

    fun getNews(category: String, country: String) =
        client
            .get()
            .uri(uriAssembler.createUri(category, country))
            .accept(APPLICATION_JSON)
            .retrieve()
            .handleStatusErrors()
            .bodyToMono(NewsResponse::class.java)

    private fun WebClient.ResponseSpec.handleStatusErrors() =
        this
            .onStatus(HttpStatus::is4xxClientError) { clientResponse ->
                clientResponse.bodyToMono(NewsResponse::class.java)
                    .doOnNext { LOGGER.error("Http status: ${clientResponse.rawStatusCode()} ${it.error}") }
                    .transform { throw NewsApiClientException(clientResponse.statusCode())  }
            }
            .onStatus(HttpStatus::is5xxServerError) { clientResponse ->
                LOGGER.error("Http status: ${clientResponse.rawStatusCode()}")
                Mono.error(NewsApiServerException(clientResponse.statusCode()))
            }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(NewsClient::class.java)
    }

}

class NewsApiServerException(status: HttpStatus) : ResponseStatusException(status)
class NewsApiClientException(status: HttpStatus) : ResponseStatusException(status)
class ApiKeyNotProvidedException : RuntimeException()

class NewsClientProperties {
    var scheme: String? = null
    var host: String? = null
    var apiKey: String? = null

}
