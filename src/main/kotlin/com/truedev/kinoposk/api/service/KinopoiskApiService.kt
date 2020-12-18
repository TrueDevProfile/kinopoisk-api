package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.Result
import com.truedev.kinoposk.api.model.film.AppendType
import com.truedev.kinoposk.api.model.film.Film
import com.truedev.kinoposk.api.model.film.frames.GalleryResult
import com.truedev.kinoposk.api.model.film.related.RelatedFilm
import com.truedev.kinoposk.api.model.film.studio.StudioResult
import com.truedev.kinoposk.api.model.film.video.VideoResult
import com.truedev.kinoposk.api.model.search.keyword.SearchResult
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FRAMES
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SEQUELS_AND_PREQUELS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_STUDIOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_VIDEOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL_V2_1
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.SEARCH_BY_KEYWORD

class KinopoiskApiService(token: String, timeoutMs: Int = 15000) {
    private val kpApiClientService: KPApiClientService = KPApiClientService(token, timeoutMs)

    /**
     * This method retrieves film data.
     *
     * @param kinopoiskId id of film from kinopoisk.
     * @param appendTypes to add additional info to response. See [AppendType].
     */
    fun getFilm(kinopoiskId: Int, appendTypes: Iterable<AppendType> = emptyList()): Result<Film> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        val appends = appendTypes.joinToString()
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId?append_to_response=$appends",
            Film::class.java
        )
    }

    /**
     * Returns frames for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getFrames(kinopoiskId: Int): Result<GalleryResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_FRAMES",
            GalleryResult::class.java
        )
    }

    /**
     * Returns videos for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getVideos(kinopoiskId: Int): Result<VideoResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_VIDEOS",
            VideoResult::class.java
        )
    }

    /**
     * Returns studios for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getStudios(kinopoiskId: Int): Result<StudioResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_STUDIOS",
            StudioResult::class.java
        )
    }

    /**
     * Returns sequels and prequels for particular kinopoiskId.
     *
     * @param kinopoiskId id of film from kinopoisk.
     */
    fun getSequelsAndPrequels(kinopoiskId: Int): Result<List<RelatedFilm>> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_SEQUELS_AND_PREQUELS",
            List::class.java as Class<List<RelatedFilm>>
        )
    }

    /**
     * Returns search result by keyword.
     *
     * @param keyword keyword to search.
     * @param page page.
     */
    fun searchByKeyword(keyword: String, page: Int = 1): Result<SearchResult> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM$SEARCH_BY_KEYWORD?keyword=$keyword&page=$page",
            SearchResult::class.java
        )
    }
}
