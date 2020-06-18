package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Expectation(
    val value: Double = 0.0,
    val count: Int = 0,
    val ready: Boolean = false
)
