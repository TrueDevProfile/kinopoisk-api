package com.truedev.kinoposk.api.model.navigator.filter

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NavigatorFiltersExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
