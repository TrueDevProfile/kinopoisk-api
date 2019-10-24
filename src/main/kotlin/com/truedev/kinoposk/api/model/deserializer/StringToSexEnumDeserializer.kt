package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.truedev.kinoposk.api.model.people.Sex

class StringToSexEnumDeserializer : JsonDeserializer<Sex>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Sex? {
        return if (p.text.isNullOrBlank()) {
            null
        } else Sex.valueOf(p.text.toUpperCase())
    }
}
