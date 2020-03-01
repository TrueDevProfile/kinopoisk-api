package com.truedev.kinoposk.api.model.search.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer
import com.truedev.kinoposk.api.model.top.VideoUrl

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchFilm(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    val year: String = "",
    val description: String = "",
    val filmLength: String = "",
    val country: String = "",
    val genre: String = "",
    val rating: String = "",
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingVoteCount: Int = 0,
    val posterURL: String = "",
    val videoURL: VideoUrl = VideoUrl()
)
