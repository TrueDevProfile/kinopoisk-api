package com.truedev.kinoposk.api.model.people

import com.fasterxml.jackson.annotation.JsonProperty

enum class Sex {
    @JsonProperty("male")
    MALE,
    @JsonProperty("female")
    FEMALE
}
