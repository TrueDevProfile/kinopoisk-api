package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    @JsonProperty(value = "creators")
    val staffItems: List<List<StaffItem>> = emptyList()
)
