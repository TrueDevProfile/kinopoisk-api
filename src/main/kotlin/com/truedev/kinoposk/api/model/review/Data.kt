package com.truedev.kinoposk.api.model.review

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val reviews: List<Review> = emptyList(),
    val page: Int = 0,
    val filmID: Int = 0,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val reviewAllCount: Int = 0,
    val reviewAllPositiveRatio: String = "",
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val reviewPositiveCount: Int = 0,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val reviewNegativeCount: Int = 0,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val reviewNeutralCount: Int = 0,
    val pagesCount: Int = 0
)
