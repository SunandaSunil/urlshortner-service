package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class LongUrlInput(

    @JsonProperty("longUrl") val longUrl: String
)