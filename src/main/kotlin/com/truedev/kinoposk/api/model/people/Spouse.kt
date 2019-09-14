package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Spouse(
    val id: Int = 0,
    val name: String = "",
    val divorced: Boolean = false,
    val divorcedReason: String = "",
    // will be enum soon...
    val sex: String = "",
    val children: Int = 0,
    val webURL: String = "",
    val relation: String = ""
)
