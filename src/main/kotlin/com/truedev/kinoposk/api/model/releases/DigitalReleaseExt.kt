package com.truedev.kinoposk.api.model.releases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DigitalReleaseExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
