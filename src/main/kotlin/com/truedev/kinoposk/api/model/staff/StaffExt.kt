package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class StaffExt(
    val resultCode: Int = 0,
    val message: String = "",
    val data: Data? = null
)
