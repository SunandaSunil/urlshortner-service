package com.project.urlshortener.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Sharing(
    @JsonProperty("protocol") val protocol: Protocol
)