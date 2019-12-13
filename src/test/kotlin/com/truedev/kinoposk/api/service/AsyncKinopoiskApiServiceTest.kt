package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.film.FilmExt
import org.junit.Assert.assertTrue
import org.junit.Test

class AsyncKinopoiskApiServiceTest {
    private val asyncKinopoiskApiService: AsyncKinopoiskApiService = AsyncKinopoiskApiService()

    @Test
    fun getFilmInfo() {
        val films: MutableList<FilmExt> = mutableListOf()
        val filmInfo = asyncKinopoiskApiService.getFilmInfo(
            301,
            { response, ext -> films.add(ext) },
            { response -> throw RuntimeException() })
        filmInfo.join()
        assertTrue(films.isNotEmpty())
    }
}
