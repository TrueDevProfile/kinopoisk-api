package com.truedev.kinoposk.api.model.search.people

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(
    val keyword: String = "",
    val pagesCount: Int = 0,
    val searchPeople: List<SearchPeople> = emptyList(),
    val searchPeoplesCountResult: Int = 0

)
