package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PeopleExt(
    val resultCode: String = "",
    val message: String = "",
    val data: Data? = null
)
