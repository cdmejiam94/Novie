package com.preeliminatorylabs.novie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.preeliminatorylabs.novie.controller.MovieController
import com.preeliminatorylabs.novie.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentPopularityViewModel(val movieController: MovieController) :  ViewModel(){

    val compositeDisposable = CompositeDisposable()

    val results: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getPopularMovies(){

        compositeDisposable.add(

            //Subscribe solo se hace en el viewmodel porque esta apegado al ciclo de vida
            movieController.getPopularMoviesApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ itemsMovies ->
                    results.value = itemsMovies
                }, {
                    it.printStackTrace()
                })
        )
    }

    //Memory leaks
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}