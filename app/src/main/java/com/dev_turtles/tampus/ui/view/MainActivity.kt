package com.dev_turtles.tampus.ui.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dev_turtles.tampus.R
import com.dev_turtles.tampus.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    //private val viewModel by lazy{ MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}