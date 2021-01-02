package com.example.moviesearcher.data.model

import com.google.gson.annotations.SerializedName

data class Movie (
    val id: Int,
    @SerializedName("poster path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String
)