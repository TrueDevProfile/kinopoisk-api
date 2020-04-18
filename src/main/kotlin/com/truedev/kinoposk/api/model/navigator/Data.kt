package com.truedev.kinoposk.api.model.navigator

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val pagesCount: Int = 0,
    val items: List<NavigatorItem> = emptyList()
)
