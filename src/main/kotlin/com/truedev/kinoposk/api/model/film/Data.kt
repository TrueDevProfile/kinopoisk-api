package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val hasSimilarFilms: Boolean = false,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val reviewsCount: Int = 0,
    val ratingData: RatingData = RatingData(),
    val filmID: Int = 0,
    val webURL: String = "",
    val nameRU: String = "",
    val nameEN: String = "",
    val year: String = "",
    val filmLength: String = "",
    val country: String = "",
    val genre: String = "",
    val slogan: String = "",
    val description: String = "",
    val ratingMPAA: String = "",
    val ratingAgeLimits: Int = 0,
    val rentData: RentData = RentData(),
    val budgetData: BudgetData = BudgetData()
)
