package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.top.Type
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class KinopoiskApiServiceTest {

    private val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService(5)

    @Test
    fun getFilmInfo() {
        val filmInfo = kinopoiskApiService.getFilmInfo(301)

        assertEquals(301, filmInfo.data?.filmID)
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
        val kpTop = kinopoiskApiService.getKPTop(1, Type.BEST_FILMS)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopPopularFilms() {
        val kpTop = kinopoiskApiService.getKPTop(1, Type.POPULAR_FILMS)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopAwaitFilms() {
        val kpTop = kinopoiskApiService.getKPTop(1, Type.AWAIT_FILMS)

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
}
