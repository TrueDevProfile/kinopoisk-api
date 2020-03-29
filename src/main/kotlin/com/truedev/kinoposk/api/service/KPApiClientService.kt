package com.truedev.kinoposk.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result
import com.truedev.kinoposk.api.model.ResponseExt
import java.net.Proxy
import java.time.LocalDateTime
import java.time.ZoneOffset

internal class KPApiClientService {
    private val mapper: ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())

    companion object {
        private const val API_URL = "https://ext.kinopoisk.ru/ios/5.0.0/"
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
    }

    fun <T> request(path: String, clazz: Class<T>, proxy: Proxy? = Proxy.NO_PROXY): ResponseExt<T> {
        val ts = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli().toString()
        val key = (path + ts + SALT).md5()
        val currentTimeMillis = System.currentTimeMillis()
        val (_, response, result) = FuelManager()
            .also { it.proxy = proxy }
            .get(API_URL + path)
            .header(getHeaders(ts, key))
            .responseString()
        println(System.currentTimeMillis() - currentTimeMillis)
        val entityExt = when (result) {
            is Result.Failure -> null
            is Result.Success -> mapper.readValue(result.get(), clazz)
        }
        return ResponseExt(resultCode = response.statusCode, message = response.responseMessage, response = entityExt)
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
