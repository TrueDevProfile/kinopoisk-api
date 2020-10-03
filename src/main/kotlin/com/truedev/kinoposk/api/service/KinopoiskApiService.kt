package com.truedev.kinoposk.api.service

import com.google.common.net.UrlEscapers
import com.truedev.kinoposk.api.model.film.FilmExt
import com.truedev.kinoposk.api.model.filmlists.BestFilmsList
import com.truedev.kinoposk.api.model.gallery.GalleryExt
import com.truedev.kinoposk.api.model.navigator.NavigatorExt
import com.truedev.kinoposk.api.model.navigator.filter.NavigatorFiltersExt
import com.truedev.kinoposk.api.model.navigator.filter.Order
import com.truedev.kinoposk.api.model.people.PeopleExt
import com.truedev.kinoposk.api.model.releases.DigitalReleaseExt
import com.truedev.kinoposk.api.model.review.ReviewListExt
import com.truedev.kinoposk.api.model.review.details.ReviewExt
import com.truedev.kinoposk.api.model.search.film.SearchFimResultExt
import com.truedev.kinoposk.api.model.search.people.SearchPeopleResultExt
import com.truedev.kinoposk.api.model.sequels.SequelExt
import com.truedev.kinoposk.api.model.staff.StaffExt
import com.truedev.kinoposk.api.model.top.TopExt
import com.truedev.kinoposk.api.model.top.Type
import com.truedev.kinoposk.api.model.tvshow.TvShowExt
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_BEST_FILMS_LIST
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_DIGITAL
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
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_SIMILAR
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_TOP
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_TV_SHOW
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.MAIN_API_URL
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.RELEASE_API_URL
import java.lang.String.valueOf
import java.net.URLEncoder
import java.time.LocalDate

class KinopoiskApiService(timeout: Int = 15000) {
    private val kpApiClientService: KPApiClientService = KPApiClientService(timeout)

    /**
     * This method retrieves film info.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getFilmInfo(filmId: Int): FilmExt {
        require(filmId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(MAIN_API_URL, "$GET_FILM?filmID=$filmId", FilmExt::class.java)
            .let { FilmExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves staff. E.g. actors, producers and so on.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getStaffList(filmId: Int): StaffExt {
        require(filmId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(MAIN_API_URL, "$GET_FILM_STAFF?filmID=$filmId", StaffExt::class.java)
            .let { StaffExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves gallery.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getGallery(filmId: Int): GalleryExt {
        require(filmId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(MAIN_API_URL, "$GET_GALLERY?filmID=$filmId", GalleryExt::class.java)
            .let { GalleryExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves reviews without details.
     *
     * @param filmId id of film from kinopoisk.
     * @param page page of results.
     */
    fun getKPReviews(filmId: Int, page: Int = 1): ReviewListExt {
        require(filmId > 0) { "Film id should be more than 0" }
        require(page > 0) { "Page should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_REVIEWS?filmID=$filmId&page=$page",
            ReviewListExt::class.java
        )
            .let { ReviewListExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves people details.
     *
     * @param peopleId id of people from kinopoisk.
     */
    fun getKPPeopleDetailView(peopleId: Int): PeopleExt {
        require(peopleId > 0) { "People id should be more than 0" }
        return kpApiClientService.request(MAIN_API_URL, "$GET_PEOPLE_DETAIL?peopleID=$peopleId", PeopleExt::class.java)
            .let { PeopleExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves top of films according to type.
     *
     * @param type type of top. E.g. POPULAR_FILMS, BEST_FILMS, AWAIT_FILMS.
     * @param page page of results.
     * @param listId id of sub list from [getBestFilmsList]
     */
    fun getKPTop(type: Type, page: Int = 1, listId: Int = 0): TopExt {
        require(page > 0) { "Page should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_TOP?page=$page&listID=$listId&type=${type.type}",
            TopExt::class.java
        )
            .let { TopExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method searches films by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInFilms(keyword: String, page: Int = 1): SearchFimResultExt {
        require(page > 0) { "Page should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_SEARCH_FILM?keyword=${
                UrlEscapers.urlFragmentEscaper()
                    .escape(keyword.replace("[^a-zA-Zа-яА-Я0-9_]".toRegex(), " "))
            }&page=$page",
            SearchFimResultExt::class.java
        ).let { SearchFimResultExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method searches people by keyword.
     *
     * @param keyword for searching.
     * @param page page of results.
     */
    fun getKPSearchInPeople(keyword: String, page: Int = 1): SearchPeopleResultExt {
        require(page > 0) { "Page should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_SEARCH_PEOPLE?keyword=${
                UrlEscapers.urlFragmentEscaper()
                    .escape(keyword.replace("[^a-zA-Zа-яА-Я0-9_]".toRegex(), " "))
            }&page=$page",
            SearchPeopleResultExt::class.java
        ).let { SearchPeopleResultExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves review details.
     *
     * @param reviewId id of review from kinopoisk.
     */
    fun getReviewDetail(reviewId: Int): ReviewExt {
        require(reviewId > 0) { "Review id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_REVIEW_DETAIL?reviewID=$reviewId", ReviewExt::class.java
        ).let { ReviewExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves different names of lists best films.
     * Default returns all best films lists. If set id of list, then returns sub lists.
     * Use @see [getKPTop] to get films from sub lists
     *
     * @param listId id of named list from kinopoisk.
     */
    fun getBestFilmsList(listId: Int = 0): BestFilmsList {
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_BEST_FILMS_LIST?listID=$listId&region_id=20615", BestFilmsList::class.java
        ).let { BestFilmsList(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves inner kinopoisk ids for countries/genres.
     *
     */
    fun getNavigatorFilters(): NavigatorFiltersExt {
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_NAVIGATOR_FILTERS?region_id=20615", NavigatorFiltersExt::class.java
        ).let {
            NavigatorFiltersExt(
                it.resultCode,
                it.message,
                it.response?.data
            )
        }
    }

    /**
     * Advanced search of films by filters.
     *
     */
    fun getNavigator(
        countryIds: List<Int> = emptyList(),
        genreIds: List<Int> = emptyList(),
        order: Order = Order.RATING,
        ratingFrom: Int = 0,
        ratingTo: Int = 10,
        yearFrom: Int = 1900,
        yearTo: Int = 2050,
        page: Int = 1
    ): NavigatorExt {
        require(page > 0) { "Page should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_NAVIGATOR?country=${URLEncoder.encode(countryIds.joinToString(separator = ","), "UTF-8")}&" +
                    "genre=${URLEncoder.encode(genreIds.joinToString(separator = ","), "UTF-8")}&" +
                    "order=${URLEncoder.encode(order.queryNameParam, "UTF-8")}&" +
                    "page=$page&" +
                    "rating=${URLEncoder.encode("$ratingFrom:$ratingTo", "UTF-8")}&" +
                    "years=${URLEncoder.encode("$yearFrom:$yearTo", "UTF-8")}&" +
                    "region_id=20615&" +
                    "type=all",
            NavigatorExt::class.java
        ).let { NavigatorExt(it.resultCode, it.message, it.response?.data) }
    }

    /**
     * This method retrieves digital releases https://www.kinopoisk.ru/comingsoon/digital/.
     *
     */
    fun getDigital(
        digitalReleaseMonth: LocalDate = LocalDate.now(),
        limit: Int = 10,
        offset: Int = 0
    ): DigitalReleaseExt {
        val month = when {
            digitalReleaseMonth.monthValue < 10 ->
                "0" + valueOf(digitalReleaseMonth.monthValue)
            else -> valueOf(digitalReleaseMonth.monthValue)
        }
        return kpApiClientService.request(
            RELEASE_API_URL,
            "$GET_DIGITAL?digitalReleaseMonth=$month.${digitalReleaseMonth.year}&" +
                    "limit=$limit&" +
                    "offset=$offset&" +
                    "region_id=20615",
            DigitalReleaseExt::class.java
        ).let {
            DigitalReleaseExt(
                it.resultCode,
                it.message,
                it.response?.data
            )
        }
    }

    /**
     * This method retrieves tv show data (series, seasons and so on).
     *
     */
    fun getTvShowInfo(tvShowId: Int): TvShowExt {
        require(tvShowId > 0) { "Tv show id should be more than 0" }
        return kpApiClientService.request(
            RELEASE_API_URL, "$GET_TV_SHOW$tvShowId",
            TvShowExt::class.java
        ).let {
            TvShowExt(
                it.response!!.success,
                it.response.data
            )
        }
    }

    /**
     * This method retrieves sequels and prequels.
     *
     */
    fun getSequelsAndPrequels(filmId: Int, page: Int): SequelExt {
        require(filmId > 0) { "Film id should be more than 0" }
        return kpApiClientService.request(
            MAIN_API_URL,
            "$GET_SIMILAR?filmID=$filmId&page=$page&region_id=20615&type=kp_sequels_and_prequels_films",
            SequelExt::class.java
        ).let {
            SequelExt(
                it.resultCode,
                it.message,
                it.response?.data
            )
        }
    }
}
