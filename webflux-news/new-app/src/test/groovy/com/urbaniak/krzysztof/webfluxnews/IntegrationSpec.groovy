package com.urbaniak.krzysztof.webfluxnews

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.common.Slf4jNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit.WireMockClassRule
import org.junit.ClassRule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract class IntegrationSpec extends Specification {

    public static final int WIREMOCK_PORT = 8202

    @Shared
    @ClassRule
    WireMockClassRule wireMockClassRule = new WireMockClassRule(config())

    def config() {
        return new WireMockConfiguration()
            .notifier(new Slf4jNotifier(true))
            .port(WIREMOCK_PORT)
    }

    def setup() {
        WireMock.reset()
    }

    protected String readFile(String fileName) {
        new File(getClass().getResource(fileName).toURI()).text
    }

}