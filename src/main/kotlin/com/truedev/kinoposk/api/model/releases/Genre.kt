package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Genre(
    val id: Int = 0,
    val name: String = "",
    // translated genre
    val slug: String = ""
)
