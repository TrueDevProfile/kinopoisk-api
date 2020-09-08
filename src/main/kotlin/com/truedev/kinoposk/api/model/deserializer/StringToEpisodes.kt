package com.truedev.kinoposk.api.model.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.truedev.kinoposk.api.model.tvshow.Episode
import java.time.LocalDate

class StringToEpisodes : JsonDeserializer<List<Episode>>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): List<Episode> {
        val node: Any = p.readValueAsTree<JsonNode>()

        return (node as ArrayNode).toList()
            .map { it.get("episode") }
            .map {
                try {
                    Episode(
                        id = it.get("id").asInt(),
                        seasonNumber = it.get("seasonNumber").asInt(),
                        episodeNumber = it.get("episodeNumber").asInt(),
                        name = it.get("name").asText().ifBlank { null },
                        nameEng = it.get("nameEng").asText().ifBlank { null },
                        synopsis = it.get("synopsis")?.asText(),
                        releaseDate = it.get("releaseDate")
                            ?.let { releaseDate -> LocalDate.parse(releaseDate.asText()) },
                        dateAccuracy = it.get("dateAccuracy")?.asText()
                    )
                } catch (e: java.lang.NullPointerException) {
                    println(it)
                    throw RuntimeException()
                }
            }
    }
}
