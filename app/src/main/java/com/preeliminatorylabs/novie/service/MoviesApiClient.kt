package com.preeliminatorylabs.novie.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2 . adapter.rxjava2.RxJava2CallAdapterFactory

const val BASE_URL = "https://api.themoviedb.org/"

class RetrofitClient {

    fun initRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(MovieApiService::class.java)

}



