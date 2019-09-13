package com.truedev.kinoposk.api.model.gallery

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Poster(
    val image: String = "",
    val preview: String = "",
    val socialURL: String = ""
)
