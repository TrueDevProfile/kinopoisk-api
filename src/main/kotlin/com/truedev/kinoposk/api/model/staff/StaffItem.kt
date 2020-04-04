package com.truedev.kinoposk.api.model.staff

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.truedev.kinoposk.api.model.deserializer.StringToProfessionDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
data class StaffItem(
    val id: Int = 0,
    val nameRU: String = "",
    val nameEN: String = "",
    val posterUrl: String? = "https://st.kp.yandex.net/images/actor/$id.jpg",
    val description: String? = null,
    val professionText: String = "",
    @JsonDeserialize(using = StringToProfessionDeserializer::class)
    val professionKey: Profession = Profession.UNKNOWN
)
