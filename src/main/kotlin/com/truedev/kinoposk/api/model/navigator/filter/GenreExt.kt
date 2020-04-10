package com.truedev.kinoposk.api.model.navigator.filter

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GenreExt(
    val id: Int = 0,
    val name: String = "",
    val popular: Boolean = false
)
