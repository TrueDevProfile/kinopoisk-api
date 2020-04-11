package com.truedev.kinoposk.api.model.navigator.filter

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val genre: List<GenreExt> = emptyList(),
    val country: List<CountryExt> = emptyList(),
    val year: YearExt = YearExt()
)
