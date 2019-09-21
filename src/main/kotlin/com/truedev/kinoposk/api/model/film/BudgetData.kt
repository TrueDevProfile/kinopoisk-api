package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToLongDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class BudgetData(
    @JsonDeserialize(using = StringToLongDeserializer::class)
    val grossUSA: Long = 0,
    @JsonDeserialize(using = StringToLongDeserializer::class)
    val grossWorld: Long = 0,
    val budget: String = "",
    @JsonDeserialize(using = StringToLongDeserializer::class)
    val marketing: Long = 0
)
