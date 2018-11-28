package com.urbaniak.krzysztof.webfluxnews.application

import java.time.Instant


interface DateFormattingPolicy {
    fun format(timestamp: Instant): String
}