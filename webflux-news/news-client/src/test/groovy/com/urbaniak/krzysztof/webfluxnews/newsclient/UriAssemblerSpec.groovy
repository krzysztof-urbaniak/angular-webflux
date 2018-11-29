package com.urbaniak.krzysztof.webfluxnews.newsclient

import kotlin.Pair
import spock.lang.Specification
import spock.lang.Unroll


class UriAssemblerSpec extends Specification {

    @Unroll
    def "should convert pair: #pair to map: #map"() {

        when:
        def result = UriAssembler.toMultiValueMap(pair)

        then:
        result == map

        where:
        pair                        | map
        new Pair("content", "json") | ["content": ["json"]]
    }

    @Unroll
    def "should convert pairs to map"() {

        given:
        def firstPair = new Pair("content", "json")
        def secondPair = new Pair("one", "two")

        def expectedMap = ["content": ["json"], "one": ["two"]]

        when:
        def result = UriAssembler.toMultiValueMap(firstPair, secondPair)

        then:
        result == expectedMap
    }
}
