package com.truedev.kinoposk.api.service

import com.google.common.net.UrlEscapers
import com.truedev.kinoposk.api.model.film.FilmExt
import com.truedev.kinoposk.api.model.filmlists.BestFilmsList
import com.truedev.kinoposk.api.model.gallery.GalleryExt
import com.truedev.kinoposk.api.model.navigator.NavigatorExt
import com.truedev.kinoposk.api.model.navigator.filter.NavigatorFiltersExt
import com.truedev.kinoposk.api.model.navigator.filter.Order
import com.truedev.kinoposk.api.model.people.PeopleExt
import com.truedev.kinoposk.api.model.review.ReviewListExt
import com.truedev.kinoposk.api.model.review.details.ReviewExt
import com.truedev.kinoposk.api.model.search.film.SearchFimResultExt
import com.truedev.kinoposk.api.model.search.people.SearchPeopleResultExt
import com.truedev.kinoposk.api.model.staff.StaffExt
import com.truedev.kinoposk.api.model.top.TopExt
import com.truedev.kinoposk.api.model.top.Type
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_BEST_FILMS_LIST
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM_STAFF
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_GALLERY
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_NAVIGATOR
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_NAVIGATOR_FILTERS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_PEOPLE_DETAIL
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_REVIEWS
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_REVIEW_DETAIL
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SEARCH_FILM
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SEARCH_PEOPLE
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_TOP

class KinopoiskApiService(timeout: Int = 15000) {
    private val kpApiClientService: KPApiClientService = KPApiClientService(timeout)

    /**
     * This method retrieves film info.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getFilmInfo(filmId: Int): FilmExt {
        return kpApiClientService.request("$GET_FILM?filmID=$filmId", FilmExt::class.java)
            .let { FilmExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves staff. E.g. actors, producers and so on.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getStaffList(filmId: Int): StaffExt {
        return kpApiClientService.request("$GET_FILM_STAFF?filmID=$filmId", StaffExt::class.java)
            .let { StaffExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves gallery.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getGallery(filmId: Int): GalleryExt {
        return kpApiClientService.request("$GET_GALLERY?filmID=$filmId", GalleryExt::class.java)
            .let { GalleryExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves reviews without details.
     *
     * @param filmId id of film from kinopoisk.
     * @param page page of results.
     */
    fun getKPReviews(filmId: Int, page: Int): ReviewListExt {
        return kpApiClientService.request("$GET_REVIEWS?filmID=$filmId&page=$page", ReviewListExt::class.java)
            .let { ReviewListExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves people details.
     *
     * @param peopleId id of people from kinopoisk.
     */
    fun getKPPeopleDetailView(peopleId: Int): PeopleExt {
        return kpApiClientService.request("$GET_PEOPLE_DETAIL?peopleID=$peopleId", PeopleExt::class.java)
            .let { PeopleExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves top of films according to type.
     *
     * @param page page of results.
     * @param type type of top. E.g. POPULAR_FILMS, BEST_FILMS, AWAIT_FILMS.
     */
    fun getKPTop(page: Int = 1, type: Type, listId: Int = 0): TopExt {
        return kpApiClientService.request("$GET_TOP?page=$page&listID=$listId&type=${type.type}", TopExt::class.java)
            .let { TopExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method searches films by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInFilms(keyword: String, page: Int): SearchFimResultExt {
        return kpApiClientService.request(
            "$GET_SEARCH_FILM?keyword=${UrlEscapers.urlFragmentEscaper().escape(keyword)}&page=$page",
            SearchFimResultExt::class.java
        ).let { SearchFimResultExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method searches people by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInPeople(keyword: String, page: Int): SearchPeopleResultExt {
        return kpApiClientService.request(
            "$GET_SEARCH_PEOPLE?keyword=${UrlEscapers.urlFragmentEscaper().escape(keyword)}&page=$page",
            SearchPeopleResultExt::class.java
        ).let { SearchPeopleResultExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves review details.
     *
     * @param reviewId id of review from kinopoisk.
     */
    fun getReviewDetail(reviewId: Int): ReviewExt {
        return kpApiClientService.request(
            "$GET_REVIEW_DETAIL?reviewID=$reviewId", ReviewExt::class.java
        ).let { ReviewExt(it.resultCode, it.message, it.response?.data) }
    }

    fun getBestFilmsList(listId: Int = 0): BestFilmsList {
        return kpApiClientService.request(
            "$GET_BEST_FILMS_LIST?listID=$listId&region_id=20615", BestFilmsList::class.java
        ).let { BestFilmsList(it.resultCode, it.message, it.response?.data) }
    }

    fun getNavigatorFilters(): NavigatorFiltersExt {
        return kpApiClientService.request(
            "$GET_NAVIGATOR_FILTERS?region_id=20615", NavigatorFiltersExt::class.java
        ).let {
            NavigatorFiltersExt(
                it.resultCode,
                it.message,
                it.response?.data
            )
        }
    }

    fun getNavigator(countryId: Int, genreId: Int, order: Order, page: Int): NavigatorExt {
        return kpApiClientService.request(
            "$GET_NAVIGATOR?country=1&country_or=1&genre=1&genre_or=1&order=${order.queryNameParam}&page=1&rating=7%3A&region_id=20615&type=all",
            NavigatorExt::class.java
        ).let { NavigatorExt(it.resultCode, it.message, it.response?.data) }
    }
}
