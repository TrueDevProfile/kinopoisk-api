package com.truedev.kinoposk.api.model.top

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val items: List<Item> = emptyList(),
    val pagesCount: Int = 0

)
