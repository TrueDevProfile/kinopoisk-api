package com.truedev.kinoposk.api.model.tvshow

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Format(
    val hasImax: Boolean,
    val has3D: Boolean
)
