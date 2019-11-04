package com.truedev.kinoposk.api.model.search.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchPeopleResultExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
