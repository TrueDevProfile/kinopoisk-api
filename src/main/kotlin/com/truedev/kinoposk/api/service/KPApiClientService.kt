package com.truedev.kinoposk.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.truedev.kinoposk.api.model.ResponseExt
import java.time.LocalDateTime
import java.time.ZoneOffset
import org.apache.commons.codec.digest.DigestUtils.md5Hex
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

internal class KPApiClientService {

    private val httpClient: CloseableHttpClient = HttpClients.createDefault()
    private val mapper: ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())

    companion object {
        private const val API_URL = "https://ext.kinopoisk.ru/ios/5.0.0/"
        private const val SALT = "IDATevHDS7"
    }

    fun <T> request(path: String, clazz: Class<T>): ResponseExt<T> {
        val ts = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli().toString()
        val key = md5Hex(path + ts + SALT)
        val request = createRequest(path, ts, key)
        return httpClient.execute(request) {
            val entityExt = when (it.statusLine.statusCode) {
                200 -> mapper.readValue(EntityUtils.toString(it.entity), clazz)
                else -> null
            }
            ResponseExt(
                it.statusLine.statusCode.toString(),
                it.statusLine.reasonPhrase,
                entityExt
            )
        }
    }

    private fun createRequest(path: String, ts: String, key: String): HttpUriRequest {
        return RequestBuilder.get()
            .setUri(API_URL + path)
            .setHeader("Android-Api-Version", "19")
            .setHeader("device", "android")
            .setHeader("User-Agent", "Android client (5.1 / api19), ru.kinopoisk/4.7.1 (1644)")
            .setHeader("X-TIMESTAMP", ts)
            .setHeader("X-SIGNATURE", key)
            .build()
    }
}
