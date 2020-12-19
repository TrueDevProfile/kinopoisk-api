package com.truedev.kinoposk.api.model.movie.video

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class VideoItem(
    val url: String?,
    val name: String?,
    val site: String?,
    val size: Int?
//    val type: VideoType?
)
