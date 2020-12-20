package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.Result
import com.truedev.kinoposk.api.model.movie.AppendType
import com.truedev.kinoposk.api.model.movie.Film
import com.truedev.kinoposk.api.model.movie.frames.GalleryResult
import com.truedev.kinoposk.api.model.movie.related.RelatedFilmItem
import com.truedev.kinoposk.api.model.movie.studio.StudioResult
import com.truedev.kinoposk.api.model.movie.video.VideoResult
import com.truedev.kinoposk.api.model.search.movie.keyword.SearchResult
import com.truedev.kinoposk.api.model.staff.Person
import com.truedev.kinoposk.api.model.staff.StaffItem
import com.truedev.kinoposk.api.model.top.movie.TopResult
import com.truedev.kinoposk.api.model.top.movie.TopType
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FRAMES
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SEQUELS_AND_PREQUELS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_STAFF
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_STUDIOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_TOP
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_VIDEOS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL_V1
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL_V2_1
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL_V2_2
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.SEARCH_BY_KEYWORD

class KinopoiskApiService(token: String, timeoutMs: Int = 15000) {
    private val kpApiClientService: KPApiClientService

    init {
        require(token.isNotBlank()) { "The API token should not be empty or null" }
        kpApiClientService = KPApiClientService(token, timeoutMs)
    }

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
    fun getSequelsAndPrequels(kinopoiskId: Int): Result<List<RelatedFilmItem>> {
        require(kinopoiskId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL_V2_1,
            "$GET_FILM/$kinopoiskId$GET_SEQUELS_AND_PREQUELS",
            List::class.java as Class<List<RelatedFilmItem>>
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

    /**
     * Returns top by particular top type [TopType].
     *
     * @param topType see [TopType].
     * @param page page.
     */
    fun getTop(topType: TopType, page: Int = 1): Result<TopResult> {
        return kpApiClientService.request(
            MAIN_API_URL_V2_2,
            "$GET_FILM$GET_TOP?type=$topType&page=$page",
            TopResult::class.java
        )
    }

    /**
     * Returns all persons by particular film id.
     *
     * @param kinopoiskFilmId film id.
     */
    fun getStaff(kinopoiskFilmId: Int): Result<List<StaffItem>> {
        return kpApiClientService.request(
            MAIN_API_URL_V1,
            "$GET_STAFF?filmId=$kinopoiskFilmId",
            List::class.java as Class<List<StaffItem>>
        )
    }

    /**
     * Returns person by particular film..
     *
     * @param kinopoiskId person id.
     */
    fun getPerson(kinopoiskId: Int): Result<Person> {
        return kpApiClientService.request(
            MAIN_API_URL_V1,
            "$GET_STAFF/$kinopoiskId",
            Person::class.java
        )
    }
}
