package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContextData(
    val id: Int,
    val slug: String?,
    val title: String,
    val originalTitle: String?,
    val normalizedTitle: String?,
    val year: Int,
    val years: List<Year> = listOf(),
    val rating: Rating,
    val expectations: Expectations,
    val currentRating: String,
    // todo enum EXPECTATIONS,RATING
    val type: String,
    val serial: Boolean,
    val shortFilm: Boolean,
    val completed: Boolean,
    val genres: List<Genre> = listOf(),
    val countries: List<Country> = listOf(),
    val duration: Int,
    val trailerId: Int,
    val time: Int,
    @JsonProperty(value = "fulltime")
    val fullTime: Int,
    @JsonProperty(value = "formats")
    val format: Format
)
