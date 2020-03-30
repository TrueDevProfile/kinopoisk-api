package com.truedev.kinoposk.api.model.review

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReviewListExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)