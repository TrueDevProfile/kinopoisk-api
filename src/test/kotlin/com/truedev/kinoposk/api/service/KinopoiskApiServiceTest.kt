package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.Result
import com.truedev.kinoposk.api.model.top.movie.TopType
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class KinopoiskApiServiceTest {

    private val kinopoiskApiService: KinopoiskApiService = KinopoiskApiService("")

    @Test
    fun `test getFilmInfo will return valid film when id exists`() {
        val result = kinopoiskApiService.getFilm(301)

        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getFrames will return valid film when id exists`() {
        val result = kinopoiskApiService.getFrames(301)

        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getVideos will return valid film when id exists`() {
        val result = kinopoiskApiService.getVideos(301)

        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getStudios will return valid film when id exists`() {
        val result = kinopoiskApiService.getStudios(301)

        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getSequelsAndPrequels will return valid film when id exists`() {
        val result = kinopoiskApiService.getSequelsAndPrequels(301)

        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test searchByKeyword will return valid keyword`() {
        val result = kinopoiskApiService.searchByKeyword("avengers")
        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getTop will return valid top 250`() {
        val result = kinopoiskApiService.getTop(TopType.TOP_250_BEST_FILMS)
        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getStaff will return valid staff`() {
        val result = kinopoiskApiService.getStaff(301)
        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }

    @Test
    fun `test getPerson will return valid person`() {
        val result = kinopoiskApiService.getPerson(301)
        assertTrue(result is Result.Success)
        assertNotNull((result as Result.Success).result)
    }
}
