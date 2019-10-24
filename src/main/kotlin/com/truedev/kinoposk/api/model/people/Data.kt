package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToLocalDateDeserializer
import com.truedev.kinoposk.api.model.deserializer.StringToSexEnumDeserializer
import com.truedev.kinoposk.api.model.gallery.Poster
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val peopleID: Int = 0,
    val webURL: String = "",
    val nameRU: String = "",
    val nameEN: String = "",
    @JsonDeserialize(using = StringToSexEnumDeserializer::class)
    val sex: Sex? = null,
    val posterURL: String = "",
    val growth: Int = 0,
    @JsonDeserialize(using = StringToLocalDateDeserializer::class)
    val birthday: LocalDate? = null,
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
