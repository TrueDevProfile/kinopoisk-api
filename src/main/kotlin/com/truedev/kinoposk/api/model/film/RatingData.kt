package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class RatingData(
    val ratingGoodReview: String = "",
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingGoodReviewVoteCount: Int = 0,
    val rating: Double = 0.0,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingVoteCount: Int = 0,
    val ratingIMDb: Double = 0.0,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingIMDbVoteCount: Int = 0,
    val ratingFilmCritics: String = "",
    val ratingFilmCriticsVoteCount: Int = 0

)
