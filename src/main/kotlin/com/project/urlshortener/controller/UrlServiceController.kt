package com.project.urlshortener.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.project.urlshortener.entity.LongUrlInput
import com.project.urlshortener.repository.UrlDetails
import com.project.urlshortener.service.UrlService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlServiceController(val service: UrlService) {

    @PostMapping("getShortUrl")
    fun getShortUrl(@RequestBody longUrl: String): UrlDetails {
        val mapper = ObjectMapper();
        var longUrlinput: LongUrlInput = mapper.readValue<LongUrlInput>(longUrl)
        return service.getShortUrl(longUrlinput.longUrl);
    }
}

