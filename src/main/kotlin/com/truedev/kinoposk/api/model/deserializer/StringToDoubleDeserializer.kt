package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class StringToDoubleDeserializer : JsonDeserializer<Double>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Double {
        return p.text?.toDoubleOrNull() ?: 0.0
    }
}
