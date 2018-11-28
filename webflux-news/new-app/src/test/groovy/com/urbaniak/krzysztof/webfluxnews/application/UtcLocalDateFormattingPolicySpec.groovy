package com.urbaniak.krzysztof.webfluxnews.application

import spock.lang.Specification
import spock.lang.Unroll

import java.time.Instant

class UtcLocalDateFormattingPolicySpec extends Specification {

    UtcLocalDateFormattingPolicy policy = new UtcLocalDateFormattingPolicy()

    @Unroll
    def "should format date: #timestamp to: #localDate"() {
        given:
        def instant = Instant.parse(timestamp)

        when:
        def result = policy.format(instant)

        then:
        result == localDate

        where:
        timestamp              | localDate
        "2018-11-20T00:17:55Z" | "2018-11-20"
        "2018-11-20T23:17:55Z" | "2018-11-20"
    }
}
