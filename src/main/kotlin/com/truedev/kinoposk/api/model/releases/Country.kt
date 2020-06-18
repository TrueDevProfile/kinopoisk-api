package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Country(
    val id: Int = 0,
    val name: String = ""
)
