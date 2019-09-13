package com.truedev.kinoposk.api.model.film

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RentData(
    var premiereRU: String = "",
    val Distributors: String = "",
    var premiereWorld: String = "",
    val premiereWorldCountry: String = "",
    val premiereDVD: String = "",
    val premiereBluRay: String = "",
    val distributorRelease: String = ""
)
