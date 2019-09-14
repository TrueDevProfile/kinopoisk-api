package com.truedev.kinoposk.api.model.review

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val reviews: List<Review> = emptyList(),
    val page: Int = 0,
    val filmID: Int = 0,
    val reviewAllCount: Int = 0,
    val reviewAllPositiveRatio: String = "",
    val reviewPositiveCount: Int = 0,
    val reviewNegativeCount: Int = 0,
    val reviewNeutralCount: Int = 0,
    val pagesCount: Int = 0
)
