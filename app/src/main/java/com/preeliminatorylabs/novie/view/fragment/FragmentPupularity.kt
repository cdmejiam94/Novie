package com.preeliminatorylabs.novie.view.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.adapter.PopularMovieAdapter
import com.preeliminatorylabs.novie.controller.MovieController
import com.preeliminatorylabs.novie.databinding.ActivityMainBindingImpl
import com.preeliminatorylabs.novie.databinding.FragmentPopularBinding
import com.preeliminatorylabs.novie.view.activity.MainActivity
import com.preeliminatorylabs.novie.viewmodel.FragmentPopularityViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentPopularityViewModelFactory
import java.time.Duration

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


        binding.actionReturn.setOnClickListener{
            activity?.startActivity(Intent(activity,MainActivity::class.java))
            Toast.makeText(getContext(),"Return to main menu", Toast.LENGTH_SHORT).show()
        }

        return root

    }


}