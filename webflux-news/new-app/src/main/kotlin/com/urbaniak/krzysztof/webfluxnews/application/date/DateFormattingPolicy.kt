package com.urbaniak.krzysztof.webfluxnews.application.date

import java.time.Instant


interface DateFormattingPolicy {
    fun format(timestamp: Instant): String
}