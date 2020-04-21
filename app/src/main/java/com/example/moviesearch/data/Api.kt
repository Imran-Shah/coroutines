package com.example.moviesearch.data

import com.example.moviesearch.domain.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(".")
    suspend fun getMovies(
        @Query("apikey") apiKey: String,
        @Query("s") movie: String,
        @Query("page") pageNo: Int
    ): Response
}