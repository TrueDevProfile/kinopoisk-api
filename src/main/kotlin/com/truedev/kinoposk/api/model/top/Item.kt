package com.truedev.kinoposk.api.model.top

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    val year: String = "",
    val filmLength: String = "",
    val country: String = "",
    val genre: String = "",
    val rating: String = "",
    val ratingVoteCount: String = "",
    val posterURL: String = "",
    val videoURL: VideoUrl = VideoUrl(),
    val ratingChange: Int = 0,
    val isRatingUP: Int = 0,
    val isAfisha: Int = 0
)
