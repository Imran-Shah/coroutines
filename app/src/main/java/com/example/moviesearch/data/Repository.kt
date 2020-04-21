package com.example.moviesearch.data

import com.example.moviesearch.domain.Response
import com.example.moviesearch.network.RetrofitClient.api

class Repository {

    suspend fun getMovies(apiKey: String, movie: String, pageNo: Int): Response {
        return api.getMovies(apiKey, movie, pageNo)
    }
}