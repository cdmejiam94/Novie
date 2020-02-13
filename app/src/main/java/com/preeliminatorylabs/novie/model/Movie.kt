package com.preeliminatorylabs.novie.model

import com.google.gson.annotations.SerializedName

class Movie(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("poster_path") val image: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("original_language") val language: String = "",
    @SerializedName("release_date") val release_date: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: Double = 0.0,
    @SerializedName("vote_average") val votes: Double = 0.0
)