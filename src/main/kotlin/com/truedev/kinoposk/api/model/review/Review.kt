package com.truedev.kinoposk.api.model.review

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToLocalDateTimeDeserializer
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class Review(
    val reviewID: Int? = null,
    val reviewType: String = "",
    val userPositiveRating: Int? = null,
    val userNegativeRating: Int? = null,
    @JsonDeserialize(using = StringToLocalDateTimeDeserializer::class)
    val reviewData: LocalDateTime? = null,
    val reviewAutor: String? = null,
    val reviewTitle: String = "",
    val reviewDescription: String = ""
)
