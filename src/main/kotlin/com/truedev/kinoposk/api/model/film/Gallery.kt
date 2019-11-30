package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToFilmPreviewDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class Gallery(
    @JsonDeserialize(using = StringToFilmPreviewDeserializer::class)
    val preview: String = ""
)
