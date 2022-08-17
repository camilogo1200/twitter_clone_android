package com.example.mptwitterclone.ui.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mptwitterclone.R
import com.example.mptwitterclone.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var isSnackBarDisplayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupNavigation()
        bindListeners()
    }

    private fun setupNavigation() {
        setupToolbarNavigation()
        setupNavigationDrawer()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = binding.mainContent.bottomNavigation

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_content_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNav.setupWithNavController(navController)
    }

    private fun setupNavigationDrawer() {
        val navView = binding.navigationView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_content_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
    }

    private fun setupToolbarNavigation() {
        //setSupportActionBar(binding.mainContent.toolbar.twitterTopToolbar)
        //appBarConfiguration = AppBarConfiguration(setOf(R.id.feed_navigation), drawerLayout)
        //setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun bindListeners() {
        val drawerLayout = binding.drawerLayout
        binding.mainContent.toolbar.profileImage.setOnClickListener {
            with(drawerLayout) {
                if (isOpen) close() else open()
            }
        }

        binding.navigationView.setNavigationItemSelectedListener {
            drawerLayout.close()
            it.isChecked = true
            true
        }
    }

}
