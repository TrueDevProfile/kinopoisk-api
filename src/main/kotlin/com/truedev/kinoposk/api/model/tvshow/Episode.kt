package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class Episode(
    val id: Int,
    val seasonNumber: Int,
    val episodeNumber: Int,
    val name: String?,
    val nameEng: String?,
    val synopsis: String?,
    val releaseDate: LocalDate?,
    val dateAccuracy: String?
)
