package com.truedev.kinoposk.api.model.navigator

enum class KinopoiskItemType {
    FILM, TV_SHOW, UNKNOWN;

    companion object {
        fun fromString(value: String): KinopoiskItemType = when (value) {
            "KPFilm" -> FILM
            "KPSerial" -> TV_SHOW
            else -> UNKNOWN
        }
    }
}
