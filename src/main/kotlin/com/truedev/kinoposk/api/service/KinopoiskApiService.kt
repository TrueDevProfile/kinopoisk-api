package com.truedev.kinoposk.api.service

import com.truedev.kinoposk.api.model.film.FilmExt
import com.truedev.kinoposk.api.model.gallery.GalleryExt
import com.truedev.kinoposk.api.model.staff.PeopleExt

class KinopoiskApiService {
    private val kpApiClientService: KPApiClientService = KPApiClientService()

    companion object {
        private const val GET_FILM = "getKPFilmDetailView"
        private const val GET_FILM_STAFF = "getStaffList"
        private const val GET_GALLERY = "getGallery"
        private const val GET_SIMILAR = "getKPFilmsList"
    }

    fun getFilmInfo(kinopoiskId: Int): FilmExt {
        return kpApiClientService.request("$GET_FILM?filmID=$kinopoiskId", FilmExt::class.java)
    }


    fun getStaffList(kinopoiskId: Int): PeopleExt {
        return kpApiClientService.request("$GET_FILM_STAFF?filmID=$kinopoiskId", PeopleExt::class.java)
    }

    fun getGallery(kinopoiskId: Int): GalleryExt {
        return kpApiClientService.request("$GET_GALLERY?filmID=$kinopoiskId", GalleryExt::class.java)
    }

}
