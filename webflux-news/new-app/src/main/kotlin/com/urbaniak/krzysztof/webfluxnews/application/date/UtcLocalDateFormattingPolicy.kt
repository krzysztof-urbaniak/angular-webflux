package com.urbaniak.krzysztof.webfluxnews.application.date

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


class UtcLocalDateFormattingPolicy: DateFormattingPolicy {
    override fun format(timestamp: Instant) =
        DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.of("UTC")).format(timestamp)
}