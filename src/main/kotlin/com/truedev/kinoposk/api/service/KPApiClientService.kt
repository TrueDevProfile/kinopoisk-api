package com.truedev.kinoposk.api.service

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.truedev.kinoposk.api.exception.BadResponseException
import com.truedev.kinoposk.api.exception.NotFoundException
import org.apache.commons.codec.digest.DigestUtils.md5Hex
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.IOException
import java.time.LocalDateTime
import java.time.ZoneOffset


internal class KPApiClientService {

    private val httpClient: CloseableHttpClient = HttpClients.createDefault()
    private val mapper: ObjectMapper = jacksonObjectMapper().registerModule(JavaTimeModule())

    companion object {
        private const val API_URL = "https://ext.kinopoisk.ru/ios/5.0.0/"
        private const val SALT = "IDATevHDS7"
    }


    fun <T> request(path: String, clazz: Class<T>): T {
        val ts = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli().toString()
        val key = md5Hex(path + ts + SALT)
        val request = createRequest(path, ts, key)
        val response = httpClient.execute(request)
        return handleResponse(response, clazz)
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

    private fun <T> handleResponse(response: CloseableHttpResponse, clazz: Class<T>): T {
        return when (response.statusLine.statusCode) {
            200 -> {
                try {
                    mapper.readValue(EntityUtils.toString(response.entity), clazz)
                } catch (ex: IOException) {
                    throw BadResponseException(ex)
                } catch (ex: JsonParseException) {
                    throw BadResponseException(ex)
                } catch (ex: JsonMappingException) {
                    throw BadResponseException(ex)
                }
            }
            404 -> throw NotFoundException()
            else -> throw BadResponseException()
        }
    }

}
