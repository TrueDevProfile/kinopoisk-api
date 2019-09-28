package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToLocalDateDeserializer
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class RentData(
    @JsonDeserialize(using = StringToLocalDateDeserializer::class)
    var premiereRU: LocalDate? = null,
    @JsonProperty(value = "Distributors")
    val distributors: String? = null,
    @JsonDeserialize(using = StringToLocalDateDeserializer::class)
    var premiereWorld: LocalDate? = null,
    val premiereWorldCountry: String? = null,
    @JsonDeserialize(using = StringToLocalDateDeserializer::class)
    val premiereDVD: LocalDate? = null,
    @JsonDeserialize(using = StringToLocalDateDeserializer::class)
    val premiereBluRay: LocalDate? = null,
    val distributorRelease: String? = null
)
