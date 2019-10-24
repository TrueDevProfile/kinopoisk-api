package com.truedev.kinoposk.api.model.review.details

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.truedev.kinoposk.api.model.review.Review

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val review: Review = Review()
)
