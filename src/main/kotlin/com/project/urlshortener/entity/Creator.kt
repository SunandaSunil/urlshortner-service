package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Creator(
    @JsonProperty("avatarUrl") val avatarUrl: String,
    @JsonProperty("fullName") val fullName: String,
    @JsonProperty("id") val id: String
)