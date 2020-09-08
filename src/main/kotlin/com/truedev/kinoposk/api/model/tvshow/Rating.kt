package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rating(
    val value: Double,
    val count: Int,
    val ready: Boolean = false
)
