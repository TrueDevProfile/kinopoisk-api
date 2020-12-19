package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonProperty

data class Spouse(
    @JsonProperty("personId")
    val kinopoiskId: Int, // kinopoisk person id
    val name: String?,
    val divorced: Boolean,
    val divorcedReason: String?,
    val sex: Sex,
    val children: Int?,
    val webUrl: String?,
    val relation: String?
)
