package com.example.moviesearch.network

import com.example.moviesearch.data.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://www.omdbapi.com"

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api: Api = retrofit.create(Api::class.java)
}