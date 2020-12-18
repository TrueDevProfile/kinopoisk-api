package com.truedev.kinoposk.api.model.film

data class Budget(
    var grossRu: Long?,
    var grossUsa: Long?,
    var grossWorld: Long?,
    var budget: String?,
    var marketing: Long?
)
