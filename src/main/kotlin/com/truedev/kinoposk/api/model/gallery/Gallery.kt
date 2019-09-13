package com.truedev.kinoposk.api.model.gallery

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Gallery(
    val poster: List<Poster> = emptyList(),
    @JsonProperty(value = "kadr_sp")
    val kadrSp: List<KadrSp> = emptyList(),
    val kadr: List<Kadr> = emptyList()
)
