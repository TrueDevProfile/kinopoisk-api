package com.truedev.kinoposk.api.model.movie.studio

data class StudioResult(
    val production: String?,
    val filming: String?,
    val imageFormat: String?,
    val camera: String?,
    val copyFormat: String?,
    val filmingFormat: String?,
    val image: String?,
    val language: String?,
    val productionStudios: List<StudioItem> = emptyList(),
    val specialEffectsStudios: List<StudioItem> = emptyList(),
    val dubbingStudios: List<StudioItem> = emptyList(),
    val rentStudios: List<StudioItem> = emptyList()
)
