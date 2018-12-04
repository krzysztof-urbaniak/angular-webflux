package com.urbaniak.krzysztof.webfluxnews.application

import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticlesController(private val service: ArticlesService) {

    @ApiOperation(
        value = "Get articles from news API",
        notes = "Articles are sent to the client as Server Sent Events",
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/news/{country}/{category}", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getArticles(
        @PathVariable(value = "country") country: String,
        @PathVariable(value = "category") category: String
    ) =
        service.getArticles(country, category)

}