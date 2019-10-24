package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class FilmExt(
    val resultCode: String = "",
    val message: String = "",
    val data: Data? = null
)
