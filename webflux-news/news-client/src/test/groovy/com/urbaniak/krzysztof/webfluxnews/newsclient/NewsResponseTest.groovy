package com.urbaniak.krzysztof.webfluxnews.newsclient

import org.springframework.beans.factory.annotation.Autowired

class NewsResponseTest extends IntegrationSpec implements NewsStub {

    @Autowired
    NewsClient client

    def "get article"() {
        given:
        String responseBody = readFile("/sample.json")

        String category = "technology"
        String country = "pl"
        String apiKey = "secretKey"

        stubForGet(
            ["category": category,
            "country": country,
             "apiKey": apiKey],
            responseBody
        )

        when:
        def response = client.getNews(category, country).block()

        then:
        response.status == "ok"
    }

}
