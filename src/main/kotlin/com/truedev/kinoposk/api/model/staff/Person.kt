package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class Person(
    @JsonProperty("personId")
    val kinopoiskId: Int, // kinopoisk person id
    val webUrl: String?,
    val nameRu: String?,
    val nameEn: String?,
    val sex: Sex?,
    val posterUrl: String?,
    val growth: Int?,
    val birthday: LocalDate?,
    val death: LocalDate?,
    val age: Int?,
    val birthplace: String?,
    val deathplace: String?,
    var spouses: List<Spouse> = emptyList(),
    val hasAwards: Int?,
    val profession: String?,
    val facts: List<String> = emptyList(),
    val films: List<PersonFilmItem> = emptyList()
)
