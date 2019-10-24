package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToSexEnumDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class Spouse(
    val id: Int = 0,
    val name: String = "",
    val divorced: Boolean = false,
    val divorcedReason: String = "",
    @JsonDeserialize(using = StringToSexEnumDeserializer::class)
    val sex: Sex? = null,
    val children: Int = 0,
    val webURL: String = "",
    val relation: String = ""
)
