package com.truedev.kinoposk.api.model.film.tvshow

import java.time.LocalDate

data class Episode(
    val seasonNumber: Int,
    val episodeNumber: Int,
    val nameRu: String?,
    val nameEn: String?,
    val synopsis: String?,
    val releaseDate: LocalDate?
)
