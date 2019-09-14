package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.truedev.kinoposk.api.model.gallery.Poster
import java.time.LocalDate


@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val peopleID: Int = 0,
    val webURL: String = "",
    val nameRU: String = "",
    val nameEN: String = "",
    // will be enum soon...
    val sex: String = "",
    val posterURL: String = "",
    val growth: Int = 0,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    val birthday: LocalDate = LocalDate.now(),
    val age: Int = 0,
    val birthplace: String = "",
    val spouse: List<Spouse> = emptyList(),
    val hasAwards: Int = 0,
    // list of films as an actor, list as a producer and so on
    val filmography: List<List<Filmography>> = emptyList(),
    val profession: String = "",
    val generalFilms: List<Filmography> = emptyList(),
    val gallery: List<Poster> = emptyList(),
//    topNewsByFilm
    val triviaData: List<String> = emptyList()
)
