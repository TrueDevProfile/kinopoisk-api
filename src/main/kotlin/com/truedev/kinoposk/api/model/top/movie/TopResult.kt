package com.truedev.kinoposk.api.model.top.movie

data class TopResult(
    val pagesCount: Int = 0,
    val films: List<TopItem> = emptyList()
)
