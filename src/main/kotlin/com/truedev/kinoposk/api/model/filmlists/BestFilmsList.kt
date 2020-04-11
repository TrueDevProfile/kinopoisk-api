package com.truedev.kinoposk.api.model.filmlists

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class BestFilmsList(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
