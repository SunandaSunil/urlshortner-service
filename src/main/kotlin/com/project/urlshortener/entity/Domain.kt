package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Domain(
    @JsonProperty("active") val active: Boolean,
    @JsonProperty("fullName") val fullName: String,
    @JsonProperty("id") val id: String,
    @JsonProperty("ref") val ref: String,
    @JsonProperty("sharing") val sharing: Sharing
)