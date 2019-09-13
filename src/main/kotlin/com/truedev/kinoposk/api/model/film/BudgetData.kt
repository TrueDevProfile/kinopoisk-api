package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BudgetData(
    val grossUSA: String = "",
    val grossWorld: String = "",
    val budget: String = "",
    val marketing: String = ""
)
