package com.truedev.kinoposk.api.model.filmlists

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BestFilmsListItem(
    val id: Int = 0,
    val title: String = ""
)
