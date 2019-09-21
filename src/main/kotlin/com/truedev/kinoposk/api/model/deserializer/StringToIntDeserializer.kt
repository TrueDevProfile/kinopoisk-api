package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class StringToIntDeserializer : JsonDeserializer<Int>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Int {
        return p.text?.replace(" ", "")?.toInt() ?: 0
    }
}
