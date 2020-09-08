package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Genre(
    val id: Int,
    val name: String,
    // translated genre
    val slug: String
)
