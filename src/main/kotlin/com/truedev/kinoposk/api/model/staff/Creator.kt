package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Creator(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    val posterURL: String? = null,
    val professionText: String = "",
    val professionKey: String = ""
)
