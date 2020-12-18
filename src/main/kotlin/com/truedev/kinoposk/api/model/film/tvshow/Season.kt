package com.truedev.kinoposk.api.model.film.tvshow

data class Season(
    val number: Int,
    val episodes: List<Episode> = emptyList()
)
