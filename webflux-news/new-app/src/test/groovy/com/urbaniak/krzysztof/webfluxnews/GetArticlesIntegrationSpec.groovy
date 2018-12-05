package com.urbaniak.krzysztof.webfluxnews

import com.urbaniak.krzysztof.webfluxnews.application.dto.ArticleDto
import com.urbaniak.krzysztof.webfluxnews.application.dto.NewsDto
import com.urbaniak.krzysztof.webfluxnews.helper.NewsStub
import com.urbaniak.krzysztof.webfluxnews.infrastructure.InMemoryNewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

class GetArticlesIntegrationSpec extends IntegrationSpec implements NewsStub {

    @Autowired
    private WebTestClient webTestClient

    @Autowired
    private InMemoryNewsRepository repo

    def "should get articles"() {
        given:
        def country = "PL"
        def category = "technology"

        String responseBody = readFile("/newsApiSample.json")

        stubForGet(
            ["category": category,
             "country" : country],
            responseBody
        )

        def expectedBody = [
            new NewsDto(
                country,
                category,
                new ArticleDto(
                    "John Major",
                    "Dedykowane akcesoria marki HAMMER",
                    "Short description",
                    "2018-11-20",
                    "Tabletowo.pl",
                    "https://example.pl/2018/11/20/sample/",
                    "https://image.pl/2018/11/20/sample/"
                )
            )
        ]

        when:
        (webTestClient.get().uri("/news/$country/$category/") as WebTestClient.RequestHeadersSpec)
            .accept(MediaType.TEXT_EVENT_STREAM)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
            .expectBodyList(NewsDto)
            .isEqualTo(expectedBody)

        then:
        true

    }
}