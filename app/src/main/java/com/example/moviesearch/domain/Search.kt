package com.example.moviesearch.domain

data class Response(
    val Search: List<Movie>?= listOf()
)

data class Movie(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String
)