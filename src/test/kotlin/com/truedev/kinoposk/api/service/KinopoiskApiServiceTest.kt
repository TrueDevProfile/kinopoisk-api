package com.truedev.kinoposk.api.service

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class KinopoiskApiServiceTest {

    val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService()
    @Before
    fun setUp() {
    }

    @Test
    fun getFilmInfo() {
        val filmInfo = kinopoiskApiService.getFilmInfo(843650)

        assertEquals(843650, filmInfo.data.filmID)
    }

    @Test
    fun getStaffList() {
        val staffList = kinopoiskApiService.getStaffList(843650)

        assertTrue(staffList.data.creators.isNotEmpty())
    }

    @Test
    fun getGallery() {
        val gallery = kinopoiskApiService.getGallery(843650)

        assertTrue(gallery.data.gallery.kadr.isNotEmpty())
        assertTrue(gallery.data.gallery.kadrSp.isNotEmpty())
        assertTrue(gallery.data.gallery.poster.isNotEmpty())
    }


}
