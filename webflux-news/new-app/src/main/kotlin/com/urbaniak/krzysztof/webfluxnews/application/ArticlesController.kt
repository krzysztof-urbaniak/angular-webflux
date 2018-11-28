package com.urbaniak.krzysztof.webfluxnews.application

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticlesController(private val service: ArticlesService) {

    @GetMapping("/news/{country}/{category}")
    fun getAllArticles(
        @PathVariable(value = "country") country: String,
        @PathVariable(value = "category") category: String
    ) =
        service.getArticles(country, category)

}