package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.truedev.kinoposk.api.model.sequels.SequelOrPrequel

class StringToSequelOrPrequelDeserializer : JsonDeserializer<SequelOrPrequel>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): SequelOrPrequel {
        return SequelOrPrequel.fromString(p.text)
    }
}
