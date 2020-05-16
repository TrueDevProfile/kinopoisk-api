package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.navigator.KinopoiskItemType
import com.truedev.kinoposk.api.model.navigator.filter.Order
import com.truedev.kinoposk.api.model.top.Type
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class KinopoiskApiServiceTest {

    private val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService()

    @Test
    fun `test getFilmInfo will return valid film when id exists`() {
        val filmInfo = kinopoiskApiService.getFilmInfo(843650)

        assertEquals(843650, filmInfo.data?.filmID)
        assertNull(filmInfo.data?.seriesInfo)
        assertEquals(KinopoiskItemType.FILM, filmInfo.data?.type)
    }

    @Test
    fun `test getFilmInfo will return tv show data when id is tv show`() {
        val filmInfo = kinopoiskApiService.getFilmInfo(1261996)

        assertEquals(1261996, filmInfo.data?.filmID)
        assertNotNull(filmInfo.data?.seriesInfo)
        assertEquals(KinopoiskItemType.TV_SHOW, filmInfo.data?.type)
    }

    @Test
    fun `test getFilmInfo will return null data when id does not exist`() {
        val filmInfo = kinopoiskApiService.getFilmInfo(1)

        assertNull(filmInfo.data?.filmID)
    }

    @Test
    fun `test getStaffList will return valid data when id exists`() {
        val staffList = kinopoiskApiService.getStaffList(221027)

        assertTrue(staffList.data?.staffItems!!.isNotEmpty())
    }

    @Test
    fun `test getStaffList will return empty staff data when id does not exist`() {
        val staffList = kinopoiskApiService.getStaffList(1)

        assertTrue(staffList.data!!.staffItems.isEmpty())
    }

    @Test
    fun `test getGallery will return valid data when id exists`() {
        val gallery = kinopoiskApiService.getGallery(843650)

        assertTrue(gallery.data?.gallery?.kadr!!.isNotEmpty())
        assertTrue(gallery.data!!.gallery.kadrSp.isNotEmpty())
        assertTrue(gallery.data!!.gallery.poster.isNotEmpty())
    }

    @Test
    fun `test getKPReviews will return valid data when id exists`() {
        val kpReviews = kinopoiskApiService.getKPReviews(843650, 2)

        assertEquals(843650, kpReviews.data?.filmID)
    }

    @Test
    fun `test getReviewDetail will return valid data when id exists`() {
        val kpReviewDetail = kinopoiskApiService.getReviewDetail(2809633)

        assertEquals(2809633, kpReviewDetail.data?.review?.reviewID)
        assertEquals("kp_review_positive", kpReviewDetail.data?.review?.reviewType)
        assertEquals("Max_Red", kpReviewDetail.data?.review?.reviewAutor)
    }

    @Test
    fun `test getKPPeopleDetailView will return valid data when id exists`() {
        val kpPeopleDetailView = kinopoiskApiService.getKPPeopleDetailView(2162346)

        assertEquals(2162346, kpPeopleDetailView.data?.peopleID)
    }

    @Test
    fun `test getKPTop will return valid data when type is BEST_FILMS`() {
        val kpTop = kinopoiskApiService.getKPTop(Type.BEST_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun `test getKPTop will return valid data when type is POPULAR_FILMS`() {
        val kpTop = kinopoiskApiService.getKPTop(Type.POPULAR_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun `test getKPTop will return valid data when type is AWAIT_FILMS`() {
        val kpTop = kinopoiskApiService.getKPTop(Type.AWAIT_FILMS, 1)

        assertTrue(kpTop.data?.items!!.isNotEmpty())
    }

    @Test
    fun `test getKPSearchInFilms will return valid data when keyword in english`() {
        val kpSearchInFilms = kinopoiskApiService.getKPSearchInFilms("avengers 2", 1)

        assertTrue(kpSearchInFilms.data?.searchFilms!!.isNotEmpty())
        assertEquals("avengers 2", kpSearchInFilms.data?.keyword)
    }

    @Test
    fun `test getKPSearchInFilms will return valid data when keyword in russian`() {
        val kpSearchInFilms = kinopoiskApiService.getKPSearchInFilms("беда всех мужчин", 1)

        assertTrue(kpSearchInFilms.data?.searchFilms!!.isNotEmpty())
        assertEquals("беда всех мужчин", kpSearchInFilms.data?.keyword)
    }

    @Test
    fun `test getKPSearchInFilms will return valid data and keyword is escaped when keyword has non valid chars`() {
        val kpSearchInFilms = kinopoiskApiService.getKPSearchInFilms("беда(всех+мужчин", 1)

        assertTrue(kpSearchInFilms.data?.searchFilms!!.isNotEmpty())
        assertEquals("беда всех мужчин", kpSearchInFilms.data?.keyword)
    }

    @Test
    fun `test getKPSearchInPeople will return valid data when keyword in english`() {
        val kpSearchInPeople = kinopoiskApiService.getKPSearchInPeople("Robert De", 1)

        assertTrue(kpSearchInPeople.data?.searchPeople!!.isNotEmpty())
        assertEquals("Robert De", kpSearchInPeople.data?.keyword)
    }

    @Test
    fun `test getKPSearchInPeople will return valid data when keyword in russian`() {
        val kpSearchInPeople = kinopoiskApiService.getKPSearchInPeople("Киану Ривз", 1)

        assertTrue(kpSearchInPeople.data?.searchPeople!!.isNotEmpty())
        assertEquals("Киану Ривз", kpSearchInPeople.data?.keyword)
    }

    @Test
    fun `test getKPSearchInPeople will return valid data and keyword is escaped when keyword has non valid chars`() {
        val kpSearchInPeople = kinopoiskApiService.getKPSearchInPeople("Киану+(Ривз", 1)

        assertTrue(kpSearchInPeople.data?.searchPeople!!.isNotEmpty())
        assertEquals("Киану  Ривз", kpSearchInPeople.data?.keyword)
    }

    @Test
    fun `test getBestFilmsList will return valid`() {
        val kpBestFilmsList = kinopoiskApiService.getBestFilmsList()

        assertTrue(kpBestFilmsList.data?.items!!.isNotEmpty())
    }

    @Test
    fun `test getNavigatorFilters will return valid data`() {
        val kpNavigatorFilters = kinopoiskApiService.getNavigatorFilters()

        assertTrue(kpNavigatorFilters.data?.country!!.isNotEmpty())
        assertTrue(kpNavigatorFilters.data?.genre!!.isNotEmpty())
    }

    @Test
    fun `test getNavigator will return valid data when filters are set`() {
        val kpNavigator = kinopoiskApiService.getNavigator(
            genreIds = listOf(1750),
            ratingFrom = 5,
            yearFrom = 2000,
            order = Order.NUM_VOTE
        )
        assertTrue(kpNavigator.data?.items!!.isNotEmpty())
    }
}
