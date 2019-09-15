package com.truedev.kinoposk.api.model.search.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchPeople(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    val description: String = "",
    val posterURL: String = ""
)
