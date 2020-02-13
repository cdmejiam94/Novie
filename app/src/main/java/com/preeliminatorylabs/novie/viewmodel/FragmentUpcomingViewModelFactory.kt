package com.preeliminatorylabs.novie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.preeliminatorylabs.novie.controller.MovieController

class FragmentUpcomingViewModelFactory(private val movieController: MovieController) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentUpcomingViewModel(movieController) as T
    }
}