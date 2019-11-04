package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.truedev.kinoposk.api.model.staff.Profession
import java.lang.IllegalArgumentException

class StringToProfessionDeserializer : JsonDeserializer<Profession>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Profession {
        return try {
            Profession.valueOf(p.text.toUpperCase())
        } catch (e: IllegalArgumentException) {
            Profession.UNKNOWN
        }
    }
}
