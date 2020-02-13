package com.preeliminatorylabs.novie.model

import com.google.gson.annotations.SerializedName

class PopularityResponse(@SerializedName("page")
                       val page: Int,

                       @SerializedName("results")
                       val results: List<Movie>)