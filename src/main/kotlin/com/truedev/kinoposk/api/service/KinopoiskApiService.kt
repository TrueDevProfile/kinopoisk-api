package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.film.FilmExt
import com.truedev.kinoposk.api.model.gallery.GalleryExt
import com.truedev.kinoposk.api.model.people.PeopleExt
import com.truedev.kinoposk.api.model.review.ReviewExt
import com.truedev.kinoposk.api.model.search.film.SearchFimResultExt
import com.truedev.kinoposk.api.model.search.people.SearchPeopleResultExt
import com.truedev.kinoposk.api.model.staff.StaffExt
import com.truedev.kinoposk.api.model.top.TopExt
import com.truedev.kinoposk.api.model.top.Type
import java.net.URLEncoder
import java.util.Optional

class KinopoiskApiService {
    private val kpApiClientService: KPApiClientService = KPApiClientService()

    companion object {
        private const val GET_FILM = "getKPFilmDetailView"
        private const val GET_FILM_STAFF = "getStaffList"
        private const val GET_GALLERY = "getGallery"
        private const val GET_SIMILAR = "getKPFilmsList"
        private const val GET_REVIEWS = "getKPReviews"
        private const val GET_REVIEW_DETAIL = "getReviewDetail"
        private const val GET_PEOPLE_DETAIL = "getKPPeopleDetailView"
        private const val GET_TOP = "getKPTop"
        private const val GET_GLOBAL_SEARCH = "getKPGlobalSearch"
        private const val GET_SEARCH_FILM = "getKPSearchInFilms"
        private const val GET_SEARCH_PEOPLE = "getKPSearchInPeople"
    }

    /**
     * This method retrieves film info.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getFilmInfo(filmId: Int): Optional<FilmExt> {
        return kpApiClientService.request("$GET_FILM?filmID=$filmId", FilmExt::class.java)
    }

    /**
     * This method retrieves staff. E.g. actors, producers and so on.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getStaffList(filmId: Int): Optional<StaffExt> {
        return kpApiClientService.request("$GET_FILM_STAFF?filmID=$filmId", StaffExt::class.java)
    }

    /**
     * This method retrieves gallery.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getGallery(filmId: Int): Optional<GalleryExt> {
        return kpApiClientService.request("$GET_GALLERY?filmID=$filmId", GalleryExt::class.java)
    }

    /**
     * This method retrieves reviews without details.
     *
     * @param filmId id of film from kinopoisk.
     * @param page page of results.
     */
    fun getKPReviews(filmId: Int, page: Int): Optional<ReviewExt> {
        return kpApiClientService.request("$GET_REVIEWS?filmID=$filmId&page=$page", ReviewExt::class.java)
    }

    /**
     * This method retrieves people details.
     *
     * @param peopleId id of people from kinopoisk.
     */
    fun getKPPeopleDetailView(peopleId: Int): Optional<PeopleExt> {
        return kpApiClientService.request("$GET_PEOPLE_DETAIL?peopleID=$peopleId", PeopleExt::class.java)
    }

    /**
     * This method retrieves top of films according to type.
     *
     * @param page page of results.
     * @param type type of top. E.g. POPULAR_FILMS, BEST_FILMS, AWAIT_FILMS.
     */
    fun getKPTop(page: Int, type: Type): Optional<TopExt> {
        return kpApiClientService.request("$GET_TOP?page=$page&type=${type.type}", TopExt::class.java)
    }

    /**
     * This method searches films by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInFilms(keyword: String, page: Int): Optional<SearchFimResultExt> {
        return kpApiClientService.request(
            "$GET_SEARCH_FILM?keyword=${URLEncoder.encode(keyword, "UTF-8")}&page=$page",
            SearchFimResultExt::class.java
        )
    }

    /**
     * This method searches people by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInPeople(keyword: String, page: Int): Optional<SearchPeopleResultExt> {
        return kpApiClientService.request(
            "$GET_SEARCH_PEOPLE?keyword=${URLEncoder.encode(keyword, "UTF-8")}&page=$page",
            SearchPeopleResultExt::class.java
        )
    }
}
