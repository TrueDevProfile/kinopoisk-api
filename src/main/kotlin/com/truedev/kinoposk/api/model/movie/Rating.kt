package com.truedev.kinoposk.api.model.movie

data class Rating(
    val rating: Double,
    val ratingVoteCount: Int,
    val ratingImdb: Double,
    val ratingImdbVoteCount: Int,
    var ratingFilmCritics: String?,
    val ratingFilmCriticsVoteCount: Int,
    val ratingAwait: String?,
    val ratingAwaitCount: Int?,
    val ratingRfCritics: String?,
    val ratingRfCriticsVoteCount: Int?
)
