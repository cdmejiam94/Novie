package com.preeliminatorylabs.novie.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.databinding.ActivityMainBinding
import com.preeliminatorylabs.novie.view.fragment.FragmentPopularity
import com.preeliminatorylabs.novie.view.fragment.FragmentTopRated
import com.preeliminatorylabs.novie.view.fragment.FragmentUpcoming
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navigateToFragment(FragmentPopularity.newInstance())

        navigationBottom.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_popular -> {
                    navigateToFragment(FragmentPopularity.newInstance())
                    true
                }
                R.id.action_top_rated -> {
                    navigateToFragment(FragmentTopRated.newInstance())
                    true
                }
                R.id.action_upcoming -> {
                    navigateToFragment(FragmentUpcoming.newInstance())
                    true
                }
                else -> false
            }
        }

//        navigationBottom.selectedItemId = R.id.action_popular
    }
}