package com.truedev.kinoposk.api.model.navigator

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer
import com.truedev.kinoposk.api.model.deserializer.StringToNavigatorItemTypeDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class NavigatorItem(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    @JsonDeserialize(using = StringToNavigatorItemTypeDeserializer::class)
    val type: KinopoiskItemType = KinopoiskItemType.UNKNOWN,
    val year: String = "",
    val country: String = "",
    val genre: String = "",
    val rating: String = "",
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingVoteCount: Int = 0,
    val bigPosterUrl: String = "https://st.kp.yandex.net/images/film_big/$id.jpg"
)
