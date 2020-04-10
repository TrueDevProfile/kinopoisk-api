package com.truedev.kinoposk.api.model.navigator

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NavigatorExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
