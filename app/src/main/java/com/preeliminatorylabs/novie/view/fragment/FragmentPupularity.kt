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
import com.preeliminatorylabs.novie.adapter.PopularMovieAdapter
import com.preeliminatorylabs.novie.controller.MovieController
import com.preeliminatorylabs.novie.databinding.FragmentPopularBinding
import com.preeliminatorylabs.novie.databinding.FragmentTopRatedBinding
import com.preeliminatorylabs.novie.model.Movie
import com.preeliminatorylabs.novie.viewmodel.FragmentPopularityViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentPopularityViewModelFactory
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModelFactory

class FragmentPopularity : Fragment() {

    private lateinit var fragmentPopularityViewModel: FragmentPopularityViewModel

    val binding: FragmentPopularBinding by lazy {
        DataBindingUtil.setContentView<FragmentPopularBinding>(
            activity as Activity,
            R.layout.fragment_popular
        )
    }

    companion object {
        fun newInstance() : Fragment{
            return  FragmentPopularity()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_popular, container, false)
        binding.recyclerViewPopularity.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        fragmentPopularityViewModel = ViewModelProviders.of(
            this,
            FragmentPopularityViewModelFactory(MovieController())
        )[FragmentPopularityViewModel::class.java]

        fragmentPopularityViewModel.results.observe(viewLifecycleOwner, Observer { items ->
            val movieAdapter = PopularMovieAdapter(items, activity as Context)
            binding.recyclerViewPopularity.adapter = movieAdapter
        })

        fragmentPopularityViewModel.getPopularMovies()
        return root

    }


}