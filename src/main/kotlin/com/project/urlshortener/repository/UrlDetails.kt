package com.project.urlshortener.repository
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("URLDETAILS")
//data class UrlDetails(@Id var id: Int,var url_id: String, var shortUrl: String, val longUrl: String)
data class UrlDetails(
    @Id val id: String?,
    val url_id: String,
    val short_url: String,
    val long_url: String
    )
