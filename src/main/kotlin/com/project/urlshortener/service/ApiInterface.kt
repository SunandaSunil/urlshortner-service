package com.project.urlshortener.service

import com.project.urlshortener.repository.UrlDetails

interface ApiInterface {
    fun getShortUrl(longUrl: String): UrlDetails

}