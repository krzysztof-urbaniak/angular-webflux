package com.urbaniak.krzysztof.webfluxnews

import com.urbaniak.krzysztof.webfluxnews.application.dto.NewsDto
import com.urbaniak.krzysztof.webfluxnews.infrastructure.InMemoryNewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Ignore
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GetArticlesIntegrationSpec extends Specification {

    @Autowired
    private WebTestClient webTestClient

    @Autowired
    private InMemoryNewsRepository repo

    @Ignore
    def "should get articles"() {
        given:
        def country = "PL"
        def category = "technology"

        when:
        webTestClient.get().uri("/news/$country/$category/")
            .accept(MediaType.TEXT_EVENT_STREAM)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM)
            .expectBodyList(NewsDto)

        then:
        category == "technology"

    }
}