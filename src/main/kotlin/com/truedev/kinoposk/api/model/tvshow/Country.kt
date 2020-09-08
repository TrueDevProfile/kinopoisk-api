package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Country(
    val id: Int,
    val name: String
)
