package com.truedev.kinoposk.api.model

data class ResponseExt<T>(
    val resultCode: Int = 0,
    val message: String = "",
    val response: T? = null
)
