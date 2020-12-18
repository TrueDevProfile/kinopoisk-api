package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.Result
import com.truedev.kinoposk.api.model.film.AppendType
import com.truedev.kinoposk.api.model.film.Film
import com.truedev.kinoposk.api.model.film.frames.Gallery
import com.truedev.kinoposk.api.model.film.related.RelatedFilm
import com.truedev.kinoposk.api.model.film.studio.StudioResult
import com.truedev.kinoposk.api.model.film.video.Video
import com.truedev.kinoposk.api.model.search.keyword.Search
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FRAMES
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SEQUELS_AND_PREQUELS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_STUDIOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_VIDEOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL_V2_1
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.SEARCH_BY_KEYWORD

class KinopoiskApiService(token: String, timeout: Int = 15000) {
    private val kpApiClientService: KPApiClientService = KPApiClientService(token, timeout)

    /**
     * This method retrieves film data.
     *
     * @param kinopoiskId id of film from kinopoisk.
     * @param appendTypes to add additional info to response. See AppendType.
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

    fun getFrames(kinopoiskId: Int): Result<Gallery> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_FRAMES",
            Gallery::class.java
        )
    }

    fun getVideos(kinopoiskId: Int): Result<Video> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_VIDEOS",
            Video::class.java
        )
    }

    fun getStudios(kinopoiskId: Int): Result<StudioResult> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_STUDIOS",
            StudioResult::class.java
        )
    }

    fun getSequelsAndPrequels(kinopoiskId: Int): Result<List<RelatedFilm>> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_SEQUELS_AND_PREQUELS",
            List::class.java as Class<List<RelatedFilm>>
        )
    }

    fun searchByKeyword(keyword: String, page: Int = 1): Result<Search> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM$SEARCH_BY_KEYWORD?keyword=$keyword&page=$page",
            Search::class.java
        )
    }
}
