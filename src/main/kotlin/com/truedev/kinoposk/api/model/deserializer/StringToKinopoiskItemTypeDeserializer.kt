package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.truedev.kinoposk.api.model.navigator.KinopoiskItemType

class StringToKinopoiskItemTypeDeserializer : JsonDeserializer<KinopoiskItemType>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): KinopoiskItemType {
        return KinopoiskItemType.fromString(p.text)
    }
}
