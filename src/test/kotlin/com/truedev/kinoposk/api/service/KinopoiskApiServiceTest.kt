package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.navigator.filter.Order
import com.truedev.kinoposk.api.model.top.Type
import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class KinopoiskApiServiceTest {

    private val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService()

    @Test
    fun getFilmInfo() {
        val filmInfo = kinopoiskApiService.getFilmInfo(843650)

        assertEquals(843650, filmInfo.data?.filmID)
    }

    @Test
    fun getTvShowInfo() {
        val filmInfo = kinopoiskApiService.getFilmInfo(1261996)

        assertEquals(1261996, filmInfo.data?.filmID)
    }

    @Test
    fun getStaffList() {
        val staffList = kinopoiskApiService.getStaffList(221027)

        assertTrue(staffList.data?.staffItems!!.isNotEmpty())
    }

    @Test
    fun getGallery() {
        val gallery = kinopoiskApiService.getGallery(843650)

        assertTrue(gallery.data?.gallery?.kadr!!.isNotEmpty())
        assertTrue(gallery.data!!.gallery.kadrSp.isNotEmpty())
        assertTrue(gallery.data!!.gallery.poster.isNotEmpty())
    }

    @Test
    fun getKPReviews() {
        val kpReviews = kinopoiskApiService.getKPReviews(843650, 2)

        assertEquals(843650, kpReviews.data?.filmID)
    }

    @Test
    fun getReviewDetail() {
        val kpReviewDetail = kinopoiskApiService.getReviewDetail(2809633)

        assertEquals(2809633, kpReviewDetail.data?.review?.reviewID)
        assertEquals("kp_review_positive", kpReviewDetail.data?.review?.reviewType)
        assertEquals("Max_Red", kpReviewDetail.data?.review?.reviewAutor)
    }

    @Test
    fun getKPPeopleDetailView() {
        val kpPeopleDetailView = kinopoiskApiService.getKPPeopleDetailView(2162346)

        assertEquals(2162346, kpPeopleDetailView.data?.peopleID)
    }

    @Test
    fun getKPTopBestFilms() {
        val kpTop = kinopoiskApiService.getKPTop(Type.BEST_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopPopularFilms() {
        val kpTop = kinopoiskApiService.getKPTop(Type.POPULAR_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopAwaitFilms() {
        val kpTop = kinopoiskApiService.getKPTop(Type.AWAIT_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInFilms() {
        val kpSearchInFilms = kinopoiskApiService.getKPSearchInFilms("avengers 2", 1)

        assertTrue(kpSearchInFilms.data?.searchFilms!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInPeople() {
        val kpSearchInPeople = kinopoiskApiService.getKPSearchInPeople("Robert De", 1)

        assertTrue(kpSearchInPeople.data?.searchPeople!!.isNotEmpty())
    }

    @Test
    fun getBestFilmsList() {
        val kpBestFilmsList = kinopoiskApiService.getBestFilmsList()

        assertTrue(kpBestFilmsList.data?.items!!.isNotEmpty())
    }

    @Test
    fun getNavigatorFilters() {
        val kpNavigatorFilters = kinopoiskApiService.getNavigatorFilters()

        assertTrue(kpNavigatorFilters.data?.country!!.isNotEmpty())
        assertTrue(kpNavigatorFilters.data?.genre!!.isNotEmpty())
    }

    @Test
    fun getNavigator() {
        val kpNavigator = kinopoiskApiService.getNavigator(
            genreIds = listOf(1750),
            ratingFrom = 5,
            yearFrom = 2000,
            order = Order.NUM_VOTE
        )
        assertTrue(kpNavigator.data?.items!!.isNotEmpty())
    }

    @Test
    fun getDigital() {
        val kpDigital = kinopoiskApiService.getDigital()

        assertTrue(kpDigital.data?.items!!.isNotEmpty())
        assertTrue(kpDigital.data?.stats?.offset == 0)
    }

    @Test
    fun getDigitalWithCustomOffset() {
        val kpDigital = kinopoiskApiService.getDigital(offset = 10)

        assertTrue(kpDigital.data?.items!!.isNotEmpty())
        assertTrue(kpDigital.data?.stats?.offset == 10)
    }
    @Test
    fun getDigitalWithCustomDate() {
        val kpDigital = kinopoiskApiService.getDigital(digitalReleaseMonth = LocalDate.of(2019, 12, 1))

        assertTrue(kpDigital.data?.items!!.isNotEmpty())
        assertTrue(kpDigital.data?.stats?.offset == 0)
    }
}
