package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class ShortUrlApiResponse(
    @JsonProperty("id") val id: String,
    @JsonProperty("title") val title: String,
    @JsonProperty("slashtag") val slashtag: String,
    @JsonProperty("destination") val destination: String,
    @JsonProperty("createdAt") val createdAt: String,
    @JsonProperty("updatedAt") val updatedAt: String,
    @JsonProperty("expiredAt") val expiredAt: Any?,
    @JsonProperty("status") val status: String,
    @JsonProperty("tags") val tags: List<Any>,
    @JsonProperty("clicks") val clicks: Int,
    @JsonProperty("isPublic") val isPublic: Boolean,
    @JsonProperty("shortUrl") val shortUrl: String,
    @JsonProperty("domainId") val domainId: String,
    @JsonProperty("domainName") val domainName: String,
    @JsonProperty("domain") val domain: Domain,
    @JsonProperty("https") val https: Boolean,
    @JsonProperty("favourite") val favourite: Boolean,
    @JsonProperty("creator") val creator: Creator,
    @JsonProperty("integrated") val integrated: Boolean
)