package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Protocol(
    @JsonProperty("allowed")val allowed: List<String>,
        @JsonProperty("default")val default: String
)