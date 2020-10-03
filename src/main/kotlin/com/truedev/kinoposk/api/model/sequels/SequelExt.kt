package com.truedev.kinoposk.api.model.sequels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SequelExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
