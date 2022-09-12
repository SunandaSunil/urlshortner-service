package com.project.urlshortener.service

import com.project.urlshortener.repository.UrlDetails
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

const val longurl = "https://stackoverflow.com/questions/56951860/kotlin-dsl-build-scripts-dependency-updates"

@SpringBootTest
internal class UrlServiceTest() {
    @Autowired
    private lateinit var userService: UrlService

    @ParameterizedTest(name = "Check short Url is not Null")
    @ValueSource(strings = [longurl])
    fun testShortUrl(inputUrl: String) {
        val response: UrlDetails = userService.getShortUrl(inputUrl)
        Assertions.assertNotNull(response.short_url)
    }
}