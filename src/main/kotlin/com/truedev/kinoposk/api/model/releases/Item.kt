package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
    val id: Int = 0,
    val title: String = "",
    val originalTitle: String = "",
    val year: Int = 0,
    val poster: Poster = Poster(),
    val genres: List<Genre> = emptyList(),
    val countries: List<Country> = emptyList(),
    val rating: Rating = Rating(),
    val expectations: Expectation = Expectation(),
    val currentRating: String = "",
    val serial: Boolean = false,
    val duration: Int = 0,
    val trailerId: Int = 0,
    val contextData: ContextData = ContextData()
)
