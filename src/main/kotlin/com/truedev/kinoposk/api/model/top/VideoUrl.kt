package com.truedev.kinoposk.api.model.top

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoUrl(
    val hd: String = "",
    val sd: String = "",
    val low: String = ""
)
