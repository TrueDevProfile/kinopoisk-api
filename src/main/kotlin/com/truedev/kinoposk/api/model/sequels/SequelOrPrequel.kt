package com.truedev.kinoposk.api.model.sequels

enum class SequelOrPrequel {
    SEQUEL, PREQUEL, UNKNOWN;

    companion object {
        fun fromString(value: String): SequelOrPrequel = when (value) {
            "Начало" -> SequelOrPrequel.PREQUEL
            "Продолжение" -> SequelOrPrequel.SEQUEL
            else -> SequelOrPrequel.UNKNOWN
        }
    }
}
