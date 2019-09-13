package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RatingData(
    val ratingGoodReview: String = "",
    val ratingGoodReviewVoteCount: String = "",
    val rating: Double = 0.0,
    val ratingVoteCount: String = "",
    val ratingIMDb: Double = 0.0,
    val ratingIMDbVoteCount: String = "",
    val ratingFilmCritics: String = "",
    val ratingFilmCriticsVoteCount: Int = 0

)
