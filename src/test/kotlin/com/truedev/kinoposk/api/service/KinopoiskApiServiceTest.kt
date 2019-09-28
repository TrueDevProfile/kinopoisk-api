package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.top.Type
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class KinopoiskApiServiceTest {

    val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService()

    @Test
    fun getFilmInfo() {
        val filmInfo = kinopoiskApiService.getFilmInfo(1300000)

        assertEquals(1300000, filmInfo?.data?.filmID)
    }

    @Test
    fun getStaffList() {
        val staffList = kinopoiskApiService.getStaffList(843650)

        assertTrue(staffList?.data?.creators!!.isNotEmpty())
    }

    @Test
    fun getGallery() {
        val gallery = kinopoiskApiService.getGallery(843650)

        assertTrue(gallery?.data?.gallery?.kadr!!.isNotEmpty())
        assertTrue(gallery.data.gallery.kadrSp.isNotEmpty())
        assertTrue(gallery.data.gallery.poster.isNotEmpty())
    }

    @Test
    fun getKPReviews() {
        val kpReviews = kinopoiskApiService.getKPReviews(843650, 2)

        assertEquals(843650, kpReviews?.data?.filmID)
    }

    @Test
    fun getKPPeopleDetailView() {
        val kpPeopleDetailView = kinopoiskApiService.getKPPeopleDetailView(10096)

        assertEquals(10096, kpPeopleDetailView?.data?.peopleID)
    }

    @Test
    fun getKPTopBestFilms() {
        val kpTop = kinopoiskApiService.getKPTop(1, Type.BEST_FILMS)

        assertTrue(kpTop?.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopPopularFilms() {
        val kpTop = kinopoiskApiService.getKPTop(1, Type.POPULAR_FILMS)

        assertTrue(kpTop?.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPTopAwaitFilms() {
        val kpTop = kinopoiskApiService.getKPTop(1, Type.AWAIT_FILMS)

        assertTrue(kpTop?.data?.items!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInFilms() {
        val kpSearchInFilms = kinopoiskApiService.getKPSearchInFilms("avengers", 1)

        assertTrue(kpSearchInFilms?.data?.searchFilms!!.isNotEmpty())
    }

    @Test
    fun getKPSearchInPeople() {
        val kpSearchInPeople = kinopoiskApiService.getKPSearchInPeople("Robert", 1)

        assertTrue(kpSearchInPeople?.data?.searchPeople!!.isNotEmpty())
    }
}
