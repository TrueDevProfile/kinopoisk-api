package com.truedev.kinoposk.api.model.movie.tvshow

data class Season(
    val number: Int,
    val episodes: List<Episode> = emptyList()
)
