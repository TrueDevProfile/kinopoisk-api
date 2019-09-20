package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class RentData(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    var premiereRU: LocalDate? = null,
    @JsonProperty(value = "Distributors")
    val distributors: String = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    var premiereWorld: LocalDate? = null,
    val premiereWorldCountry: String = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    val premiereDVD: LocalDate? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    val premiereBluRay: LocalDate? = null,
    val distributorRelease: String = ""
)
