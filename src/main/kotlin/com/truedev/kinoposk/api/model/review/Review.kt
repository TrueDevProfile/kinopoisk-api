package com.truedev.kinoposk.api.model.review

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class Review(
    val reviewID: Int = 0,
    val reviewType: String = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd.MM.yyyy")
    val reviewData: LocalDateTime? = null,
    val reviewAutor: String = "",
    val reviewTitle: String = "",
    val reviewDescription: String = ""
)
