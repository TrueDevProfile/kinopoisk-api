package com.truedev.kinoposk.api.model.search.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val keyword: String = "",
    val pagesCount: Int = 0,
    val searchFilms: List<SearchFilm> = emptyList(),
    val searchFilmsCountResult: Int = 0
)
