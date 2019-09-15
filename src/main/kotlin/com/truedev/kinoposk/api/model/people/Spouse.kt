package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Spouse(
    val id: Int = 0,
    val name: String = "",
    val divorced: Boolean = false,
    val divorcedReason: String = "",
    val sex: Sex = Sex.MALE,
    val children: Int = 0,
    val webURL: String = "",
    val relation: String = ""
)
