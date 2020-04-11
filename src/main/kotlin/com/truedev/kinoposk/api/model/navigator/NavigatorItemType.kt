package com.truedev.kinoposk.api.model.navigator

enum class NavigatorItemType {
    FILM, SERIAL, UNKNOWN;

    companion object {
        fun fromString(value: String): NavigatorItemType = when (value) {
            "KPFilm" -> FILM
            "KPSerial" -> SERIAL
            else -> UNKNOWN
        }
    }
}
