package com.truedev.kinoposk.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.truedev.kinoposk.api.model.ResponseExt
import java.time.LocalDateTime
import java.time.ZoneOffset

internal class KPApiClientService(private val timeout: Int) {
    private val mapper: ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())

    companion object {
        const val MAIN_API_URL = "https://ext.kinopoisk.ru/ios/5.0.0/"
        const val RELEASE_API_URL = "https://ma.kinopoisk.ru"
        private const val SALT = "IDATevHDS7"

        const val GET_FILM = "getKPFilmDetailView"
        const val GET_FILM_STAFF = "getStaffList"
        const val GET_GALLERY = "getGallery"
        const val GET_SIMILAR = "getKPFilmsList"
        const val GET_REVIEWS = "getKPReviews"
        const val GET_REVIEW_DETAIL = "getKPReviewDetail"
        const val GET_PEOPLE_DETAIL = "getKPPeopleDetailView"
        const val GET_TOP = "getKPTop"
        const val GET_GLOBAL_SEARCH = "getKPGlobalSearch"
        const val GET_SEARCH_FILM = "getKPSearchInFilms"
        const val GET_SEARCH_PEOPLE = "getKPSearchInPeople"
        const val GET_BEST_FILMS_LIST = "getBestFilmsList"
        const val GET_NAVIGATOR_FILTERS = "navigatorFilters"
        const val GET_NAVIGATOR = "navigator"
        const val GET_DIGITAL = "/k/v1/films/releases/digital"
        const val GET_TV_SHOW = "/k/v1/serial/"
    }

    fun <T> request(url: String, path: String, clazz: Class<T>): ResponseExt<T> {
        val ts = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli().toString()
        val key = (path + ts + SALT).md5()
        val (_, response, result) = (url + path)
            .httpGet()
            .timeout(timeout)
            .timeoutRead(timeout)
            .header(getHeaders(ts, key))
            .responseString()

        return when (result) {
            is Result.Failure -> ResponseExt(
                resultCode = response.statusCode,
                message = result.error.message ?: response.responseMessage
            )
            is Result.Success -> {
                val entityExt = mapper.readValue(result.get(), clazz)
                ResponseExt(resultCode = response.statusCode, message = response.responseMessage, response = entityExt)
            }
        }
    }

    private fun getHeaders(ts: String, key: String): Map<String, String> {
        return mapOf(
            "Android-Api-Version" to "19",
            "device" to "android",
            "User-Agent" to "Android client (5.1 / api19), ru.kinopoisk/4.7.1 (1644)",
            "X-TIMESTAMP" to ts,
            "X-SIGNATURE" to key
        )
    }
}
