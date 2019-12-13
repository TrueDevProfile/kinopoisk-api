package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.top.Type
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DefaultKinopoiskApiServiceTest {

    private val defaultKinopoiskApiService: DefaultKinopoiskApiService = DefaultKinopoiskApiService()

    @Test
    fun getFilmInfo() {
        val filmInfo = defaultKinopoiskApiService.getFilmInfo(301)

        assertEquals(301, filmInfo.data?.filmID)
    }

    @Test
    fun getStaffList() {
        val staffList = defaultKinopoiskApiService.getStaffList(221027)

        assertTrue(staffList.data?.creators!!.isNotEmpty())
    }

    @Test
    fun getGallery() {
        val gallery = defaultKinopoiskApiService.getGallery(843650)

        assertTrue(gallery.data?.gallery?.kadr!!.isNotEmpty())
        assertTrue(gallery.data!!.gallery.kadrSp.isNotEmpty())
        assertTrue(gallery.data!!.gallery.poster.isNotEmpty())
    }

    @Test
    fun getKPReviews() {
        val kpReviews = defaultKinopoiskApiService.getKPReviews(843650, 2)

        assertEquals(843650, kpReviews.data?.filmID)
    }

    @Test
    fun getReviewDetail() {
        val kpReviewDetail = defaultKinopoiskApiService.getReviewDetail(2809633)

        assertEquals(2809633, kpReviewDetail.data?.review?.reviewID)
        assertEquals("kp_review_positive", kpReviewDetail.data?.review?.reviewType)
        assertEquals("Max_Red", kpReviewDetail.data?.review?.reviewAutor)
    }

    @Test
    fun getKPPeopleDetailView() {
        val kpPeopleDetailView = defaultKinopoiskApiService.getKPPeopleDetailView(2162346)

        assertEquals(2162346, kpPeopleDetailView.data?.peopleID)
    }

    @Test
    fun getKPTopBestFilms() {
        val kpTop = defaultKinopoiskApiService.getKPTop(1, Type.BEST_FILMS)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopPopularFilms() {
        val kpTop = defaultKinopoiskApiService.getKPTop(1, Type.POPULAR_FILMS)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopAwaitFilms() {
        val kpTop = defaultKinopoiskApiService.getKPTop(1, Type.AWAIT_FILMS)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInFilms() {
        val kpSearchInFilms = defaultKinopoiskApiService.getKPSearchInFilms("avengers 2", 1)

        assertTrue(kpSearchInFilms.data?.searchFilms!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInPeople() {
        val kpSearchInPeople = defaultKinopoiskApiService.getKPSearchInPeople("Robert De", 1)

        assertTrue(kpSearchInPeople.data?.searchPeople!!.isNotEmpty())
    }
}
