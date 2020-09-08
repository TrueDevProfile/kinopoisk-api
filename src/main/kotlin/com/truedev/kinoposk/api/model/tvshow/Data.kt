package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val description: String?,
    val downloadAvailable: Boolean,
    val contextData: ContextData,
    val seasons: List<Season> = listOf()
)
