package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Stats(
    val total: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0
)
