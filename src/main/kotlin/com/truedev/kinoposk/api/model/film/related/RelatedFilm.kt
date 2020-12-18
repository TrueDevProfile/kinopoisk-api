package com.truedev.kinoposk.api.model.film.related

import com.fasterxml.jackson.annotation.JsonProperty

data class RelatedFilm(
    @JsonProperty("filmId")
    val kinopoiskId: Int,
    var nameRu: String?,
    var nameEn: String?,
    val posterUrl: String,
    val posterUrlPreview: String,
    var relationType: SequelOrPrequel
)
