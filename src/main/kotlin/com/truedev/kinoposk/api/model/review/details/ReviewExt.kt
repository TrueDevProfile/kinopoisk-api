package com.truedev.kinoposk.api.model.review.details

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReviewExt(
    val resultCode: String = "",
    val message: String = "",
    val data: Data? = null
)
