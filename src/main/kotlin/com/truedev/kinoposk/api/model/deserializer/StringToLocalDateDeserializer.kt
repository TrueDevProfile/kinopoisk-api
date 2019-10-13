package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class StringToLocalDateDeserializer : JsonDeserializer<LocalDate>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDate? {
        return try {
            LocalDate.parse(p.text, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        } catch (e: DateTimeParseException) {
            try {
                YearMonth.parse(p.text, DateTimeFormatter.ofPattern("MM.yyyy")).atDay(1)
                //            todo error 00.1996 -> only year then | 00.00.1994 https://www.kinopoisk.ru/film/41023/
                // todo temporary fix
            } catch (e: Exception) {
                null
            }
        }
    }
}
