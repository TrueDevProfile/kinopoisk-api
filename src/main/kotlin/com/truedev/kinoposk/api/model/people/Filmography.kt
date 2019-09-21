package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Filmography(
    val filmID: Int = 0,
    // Or float or procent
    val rating: String = "",
    // can be with whitespace
    val ratingVoteCount: String = "",
    val description: String = "",
    val professionText: String = "",
    val posterURL: String = "",
    // will be enum soon...
    val professionKey: String = "",
    val nameRU: String = "",
    val nameEN: String = "",
    // can be like 2002-...
    val year: String = ""
)
