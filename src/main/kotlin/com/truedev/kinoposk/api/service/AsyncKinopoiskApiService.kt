package com.truedev.kinoposk.api.service

import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.requests.CancellableRequest
import com.truedev.kinoposk.api.model.film.FilmExt
import com.truedev.kinoposk.api.service.KPApiClientService.Companion.GET_FILM

class AsyncKinopoiskApiService {

    private val kpApiClientService: KPApiClientService = KPApiClientService()

    /**
     * This method retrieves film info.
     *
     * @param filmId id of film from kinopoisk.
     */
    fun getFilmInfo(
        filmId: Int,
        onSuccess: (response: Response, ext: FilmExt) -> Unit,
        onFailure: (response: Response) -> Unit
    ): CancellableRequest {
        return kpApiClientService.request(
            "$GET_FILM?filmID=$filmId", FilmExt::class.java, onSuccess, onFailure
        )
    }
}
