package com.project.urlshortener.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlServiceRepository : CrudRepository<UrlDetails, String> {
    @Query("select * from urldetails")
    fun findAllUrls(): List<UrlDetails>
}

