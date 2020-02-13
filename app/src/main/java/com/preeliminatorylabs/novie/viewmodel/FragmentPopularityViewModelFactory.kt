package com.preeliminatorylabs.novie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.preeliminatorylabs.novie.controller.MovieController

class FragmentPopularityViewModelFactory(private val movieController: MovieController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentPopularityViewModel(movieController) as T
    }
}