package com.truedev.kinoposk.api.model.gallery

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class KadrSp(
    val image: String = "",
    val preview: String = "",
    val socialURL: String = ""
)
