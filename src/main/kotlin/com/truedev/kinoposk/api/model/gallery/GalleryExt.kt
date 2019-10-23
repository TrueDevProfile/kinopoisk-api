package com.truedev.kinoposk.api.model.gallery

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GalleryExt(
    val resultCode: String = "",
    val message: String = "",
    val data: Data? = null
)
