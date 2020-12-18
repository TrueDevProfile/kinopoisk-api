package com.truedev.kinoposk.api.model.film.video

data class VideoResult(
    val trailers: List<VideoItem> = emptyList(),
    val teasers: List<VideoItem> = emptyList()
)
