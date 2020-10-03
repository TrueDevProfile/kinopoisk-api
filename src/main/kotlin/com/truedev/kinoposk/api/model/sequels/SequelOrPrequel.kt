package com.truedev.kinoposk.api.model.sequels

enum class SequelOrPrequel {
    SEQUEL, PREQUEL, REMAKE, UNKNOWN;

    companion object {
        fun fromString(value: String): SequelOrPrequel = when (value) {
            "Начало" -> SequelOrPrequel.PREQUEL
            "Продолжение" -> SequelOrPrequel.SEQUEL
            "Ремейк" -> SequelOrPrequel.REMAKE
            else -> SequelOrPrequel.UNKNOWN
        }
    }
}
