package com.preeliminatorylabs.novie.controller

import com.preeliminatorylabs.novie.model.Movie
import com.preeliminatorylabs.novie.service.RetrofitClient
import io.reactivex.Single

class MovieController {

    val service = RetrofitClient().initRetrofit()

    fun getPopularMoviesApi(): Single<List<Movie>> {
        //Logica de negocio
        return service.getPopularMovies().map {
            it.results
        }

    }

    fun getTopRatedMoviesApi(): Single<List<Movie>> {
        //Logica de negocio
        return service.getTopRatedMovies().map {
            it.results
        }

    }

    fun getUpcomingMoviesApi(): Single<List<Movie>> {
        //Logica de negocio
        return service.getUpcomingMovies().map {
            it.results
        }

    }
}