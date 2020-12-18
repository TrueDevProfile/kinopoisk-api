package com.truedev.kinoposk.api.model

sealed class Result<T> {
    data class Success<T>(val httpStatus: Int, val result: T) : Result<T>()
    data class Failure<T>(val httpStatus: Int, val error: String) : Result<T>()
}
