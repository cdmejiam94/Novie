package com.preeliminatorylabs.novie.service

import com.preeliminatorylabs.novie.model.TopRatedResponse
import io.reactivex.Single
import retrofit2.http.GET

const val API_KEY = "fb7146f0ea7129cd2c5a3a34aa4a9f87"

interface MovieApiService {

    /*@GET("3/movie/popular?api_key="+ API_KEY)
    fun getPopularMovies(): Single<DataPopularMovies>


    @GET("3/movie/upcoming"+API_KEY)
    fun getUpcomingMovies(): Single<DataUpcomingMovies>*/


    @GET("3/movie/top_rated?api_key="+API_KEY)
    fun getTopRatedMovies(): Single<TopRatedResponse>
}