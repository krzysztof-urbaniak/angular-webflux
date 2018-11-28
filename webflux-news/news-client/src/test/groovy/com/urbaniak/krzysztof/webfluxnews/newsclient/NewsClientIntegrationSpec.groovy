package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.beans.factory.annotation.Autowired

class NewsClientIntegrationSpec extends IntegrationSpec implements NewsStub {

    @Autowired
    NewsClient client

    def "should get article"() {
        given:
        String responseBody = readFile("/sample.json")

        String category = "technology"
        String country = "pl"

        stubForGet(
            ["category": category,
            "country": country],
            responseBody
        )

        when:
        def response = client.getNews(category, country).block()

        then:
        response.status == "ok"

        with(response.articles[0]) {
            source.name == "Tabletowo.pl"
            urlToImage == null
            publishedAt == "2018-11-20T20:40:00Z"
        }

        with(response.articles[1]) {
            source.name == "Antyweb.pl"
            urlToImage == "https://static.antyweb.pl/wp-content/uploads/2018/11/20211719/microsoft.jpg"
            publishedAt == "2018-11-20T20:17:55Z"
        }

        verifyGetRequestWasSent(["category": category, "country": country])
    }

}
