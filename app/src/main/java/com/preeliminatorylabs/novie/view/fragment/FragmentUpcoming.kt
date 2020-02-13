package com.preeliminatorylabs.novie.view.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.adapter.MovieAdapter
import com.preeliminatorylabs.novie.adapter.UpcomingMovieAdapter
import com.preeliminatorylabs.novie.controller.MovieController
import com.preeliminatorylabs.novie.databinding.FragmentTopRatedBinding
import com.preeliminatorylabs.novie.databinding.FragmentUpcomingBinding
import com.preeliminatorylabs.novie.model.Movie
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModelFactory
import com.preeliminatorylabs.novie.viewmodel.FragmentUpcomingViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentUpcomingViewModelFactory

class FragmentUpcoming : Fragment() {

    private lateinit var fragmentUpcomingViewModel: FragmentUpcomingViewModel

    val binding: FragmentUpcomingBinding by lazy {
        DataBindingUtil.setContentView<FragmentUpcomingBinding>(
            activity as Activity,
            R.layout.fragment_upcoming
        )
    }

    companion object {
        fun newInstance() : Fragment{
            return  FragmentUpcoming()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_upcoming, container, false)
        binding.recyclerViewUpcoming.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        fragmentUpcomingViewModel = ViewModelProviders.of(
            this,
            FragmentUpcomingViewModelFactory(MovieController())
        )[FragmentUpcomingViewModel::class.java]

        fragmentUpcomingViewModel.results.observe(viewLifecycleOwner, Observer { items ->
            val movieAdapter = UpcomingMovieAdapter(items, activity as Context)
            binding.recyclerViewUpcoming.adapter = movieAdapter
        })

        fragmentUpcomingViewModel.getUpcomingMovies()
        return root

    }


}