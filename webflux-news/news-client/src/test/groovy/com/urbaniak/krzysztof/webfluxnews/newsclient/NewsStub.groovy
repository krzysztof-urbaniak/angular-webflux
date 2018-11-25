package com.urbaniak.krzysztof.webfluxnews.newsclient

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse
import static com.github.tomakehurst.wiremock.client.WireMock.matching
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import static com.github.tomakehurst.wiremock.client.WireMock.verify

trait NewsStub {

    @Value("\${news-client.apiKey}")
    String apiKey

    private def PATH = "/v2/top-headlines"

    private def createPath(String country, String category, String apiKey) {
        "$PATH\\?country=$country\\&category=$category\\&apiKey=$apiKey"
    }

    private def verifyRequestWasSent(Closure<RequestPatternBuilder> c, int counter, String url) {
        verify(counter, c(urlMatching(url)))
        true
    }

    private def stubRequest(Closure<MappingBuilder> c, String path, int status, String body) {
        stubFor(
            c(urlMatching(path))
                .withHeader(HttpHeaders.ACCEPT, matching(MediaType.APPLICATION_JSON.toString()))
                .willReturn(aResponse()
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .withStatus(status)
                .withBody(body)
            )
        )
    }

    def stubForGet(Map params, String response, int status = 200) {
        stubRequest(
            WireMock.&get,
            createPath(
                params.get("country") as String,
                params.get("category") as String,
                apiKey
            ),
            status,
            response
        )
    }

    def verifyGetRequestWasSent(Map params, int counter = 1) {
        verifyRequestWasSent(
            WireMock.&getRequestedFor,
            counter,
            createPath(
                params.get("country") as String,
                params.get("category") as String,
                apiKey
            )
        )
        true
    }
}