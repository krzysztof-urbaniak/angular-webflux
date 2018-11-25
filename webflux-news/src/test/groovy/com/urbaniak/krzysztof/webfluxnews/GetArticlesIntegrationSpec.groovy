package com.urbaniak.krzysztof.webfluxnews

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GetArticlesIntegrationSpec extends Specification {

    @Autowired
    private WebTestClient webTestClient

    @Autowired
    private InMemoryNewsRepository repo

    def "should get articles"() {
        given:
        def country = "PL"
        def category = "technology"

        when:
        webTestClient.get().uri("/news/$country/$category/")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
            .expectBodyList(NewsDto)

        then:
        category == "technology"

    }
}