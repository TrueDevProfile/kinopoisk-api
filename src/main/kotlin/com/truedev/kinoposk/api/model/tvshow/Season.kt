package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToEpisodes
@JsonIgnoreProperties(ignoreUnknown = true)
data class Season(
    val number: Int,
    @JsonDeserialize(using = StringToEpisodes::class)
    val episodes: List<Episode> = listOf()
)
