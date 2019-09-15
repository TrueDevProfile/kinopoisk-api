package com.truedev.kinoposk.api.model.search.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchFimResultExt(
    val resultCode: String = "",
    val message: String = "",
    val data: Data = Data()
)
