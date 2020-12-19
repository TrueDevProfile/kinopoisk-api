package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonProperty

data class StaffItem(
    @JsonProperty("staffId")
    val kinopoiskId: Int, // kinopoisk person id
    val nameRu: String?,
    val nameEn: String?,
    val description: String?,
    val posterUrl: String?,
    val professionText: String,
    val professionKey: Profession = Profession.UNKNOWN
)
