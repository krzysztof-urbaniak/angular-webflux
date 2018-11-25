package com.urbaniak.krzysztof.webfluxnews

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ArticlesController(val repo: InMemoryNewsRepository) {

    @GetMapping("/news/{country}/{category}")
    fun getAllArticles(
        @PathVariable(value = "country") country: String,
        @PathVariable(value = "category") category: String
    ) =
        Mono.just(repo.getArticles(country, category))

}