package com.preeliminatorylabs.novie.view.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.adapter.TopRatedMovieAdapter
import com.preeliminatorylabs.novie.controller.MovieController
import com.preeliminatorylabs.novie.databinding.FragmentTopRatedBinding
import com.preeliminatorylabs.novie.view.activity.MainActivity
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModel
import com.preeliminatorylabs.novie.viewmodel.FragmentTopRatedViewModelFactory

class FragmentTopRated : Fragment() {

    private lateinit var fragmentTopRatedViewModel: FragmentTopRatedViewModel

    val binding: FragmentTopRatedBinding by lazy {
        DataBindingUtil.setContentView<FragmentTopRatedBinding>(
            activity as Activity,
            R.layout.fragment_top_rated
        )
    }

    companion object {
        fun newInstance() : Fragment{
            return  FragmentTopRated()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_top_rated, container, false)

//        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        fragmentTopRatedViewModel = ViewModelProviders.of(
            this,
            FragmentTopRatedViewModelFactory(MovieController())
        )[FragmentTopRatedViewModel::class.java]

        fragmentTopRatedViewModel.results.observe(viewLifecycleOwner, Observer { items ->
            val movieAdapter = TopRatedMovieAdapter(items, activity as Context)
//            binding.recyclerViewTopRated.adapter = movieAdapter
            binding.recyclerViewTopRated.adapter = movieAdapter
        })

        fragmentTopRatedViewModel.getTopRatedMovies()

        binding.actionReturn.setOnClickListener{
            activity?.startActivity(Intent(activity, MainActivity::class.java))
            Toast.makeText(getContext(),"Return to main menu", Toast.LENGTH_SHORT).show()
        }

        return root

    }


}
