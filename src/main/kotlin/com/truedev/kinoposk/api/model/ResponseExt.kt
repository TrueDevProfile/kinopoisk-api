package com.truedev.kinoposk.api.model

data class ResponseExt<T>(
    val resultCode: String = "",
    val message: String = "",
    val response: T? = null
)
