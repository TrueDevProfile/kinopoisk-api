package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContextData(
    val isDigital: Boolean = false,
    val releaseDate: LocalDate = LocalDate.now()
)
