package com.truedev.kinoposk.api.model.sequels

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToIntDeserializer
import com.truedev.kinoposk.api.model.deserializer.StringToKinopoiskItemTypeDeserializer
import com.truedev.kinoposk.api.model.deserializer.StringToSequelOrPrequelDeserializer
import com.truedev.kinoposk.api.model.navigator.KinopoiskItemType

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
    @JsonDeserialize(using = StringToKinopoiskItemTypeDeserializer::class)
    val type: KinopoiskItemType = KinopoiskItemType.UNKNOWN,
    val id: Int,
    val nameRU: String?,
    val nameEN: String?,
    // can be range of years for tv show
    val year: String?,
    // can be percent
    val rating: String?,
    @JsonDeserialize(using = StringToIntDeserializer::class)
    val ratingVoteCount: Int?,
    val posterURL: String?,
    val filmLength: String?,
    val country: String?,
    val genre: String?,
    @JsonDeserialize(using = StringToSequelOrPrequelDeserializer::class)
    @JsonProperty("filmTypeText")
    val sequelOrPrequel: SequelOrPrequel
)
