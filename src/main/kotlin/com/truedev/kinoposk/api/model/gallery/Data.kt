package com.truedev.kinoposk.api.model.gallery

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val gallery: Gallery = Gallery()
)
