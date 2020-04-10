package com.truedev.kinoposk.api.model.filmlists

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val items: List<BestFilmsListItem> = emptyList()
)
