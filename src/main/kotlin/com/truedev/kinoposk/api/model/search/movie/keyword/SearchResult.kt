package com.truedev.kinoposk.api.model.search.movie.keyword

data class SearchResult(
    val keyword: String?,
    val pagesCount: Int,
    val films: List<SearchItem> = emptyList(),
    val searchFilmsCountResult: Int?
)
