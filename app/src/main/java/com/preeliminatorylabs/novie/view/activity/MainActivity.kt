package com.preeliminatorylabs.novie.view.activity

import android.os.Bundle
import com.preeliminatorylabs.novie.R
import com.preeliminatorylabs.novie.view.fragment.FragmentUpcoming

class MainActivity : ActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToFragment(FragmentUpcoming.newInstance())
    }
}