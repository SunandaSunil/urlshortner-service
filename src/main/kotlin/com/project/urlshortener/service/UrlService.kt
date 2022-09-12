package com.project.urlshortener.service


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.project.urlshortener.entity.ShortUrlApiResponse
import com.project.urlshortener.repository.UrlDetails
import com.project.urlshortener.repository.UrlServiceRepository
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

const val BASE_URL = "https://api.rebrandly.com/v1/links/"

@Service
class UrlService(val urlrepository: UrlServiceRepository) : ApiInterface {

    override fun getShortUrl(longUrl: String): UrlDetails {
        //httpClient to invoke rebrandly api for url shortening
        val (client, request) = createRequest(longUrl)
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val mapper = ObjectMapper();
        var shrtUrl: ShortUrlApiResponse = mapper.readValue<ShortUrlApiResponse>(response.body())
        var urlDetail = UrlDetails(
            null,
            shrtUrl.id,
            shrtUrl.shortUrl, longUrl
        )
        //save entity to db
        return post(urlDetail)

    }

    private fun createRequest(longUrl: String): Pair<HttpClient, HttpRequest> {
        val domainVal = mapOf("fullName" to "rebrand.ly")
        val values =
            mapOf("destination" to "$longUrl", "domain" to domainVal)
        val objectMapper = ObjectMapper()
        val requestBody: String = objectMapper
            .writeValueAsString(values)

        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .header("Content-Type", "application/json")
            .header("apikey", "4f38003e8c264202b2523bdfdb6abdd4")
            .uri(URI.create(BASE_URL))
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()
        return Pair(client, request)
    }

    fun post(urlDetail: UrlDetails): UrlDetails {
        return urlrepository.save(urlDetail)
    }

    fun findAllUrls(): List<UrlDetails> = urlrepository.findAllUrls()
}