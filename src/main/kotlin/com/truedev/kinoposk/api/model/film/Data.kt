package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer
import com.truedev.kinoposk.api.model.staff.StaffItem

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
    val bigPosterUrl: String = "https://st.kp.yandex.net/images/film_big/$filmID",
    val filmLength: String? = null,
    val country: String = "",
    val genre: String = "",
    val slogan: String? = null,
    val gallery: List<Gallery> = emptyList(),
    val description: String? = null,
    val ratingMPAA: String? = null,
    val ratingAgeLimits: Int? = null,
    val rentData: RentData = RentData(),
    val budgetData: BudgetData = BudgetData(),
    val isIMAX: Boolean = false,
    val is3D: Boolean = false,
    val creators: List<List<StaffItem>> = emptyList()
)
