package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.truedev.kinoposk.api.model.navigator.NavigatorItemType

class StringToNavigatorItemTypeDeserializer : JsonDeserializer<NavigatorItemType>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): NavigatorItemType {
        return NavigatorItemType.fromString(p.text)
    }
}
