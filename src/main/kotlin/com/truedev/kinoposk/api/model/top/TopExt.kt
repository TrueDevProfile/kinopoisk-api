package com.truedev.kinoposk.api.model.top

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TopExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
