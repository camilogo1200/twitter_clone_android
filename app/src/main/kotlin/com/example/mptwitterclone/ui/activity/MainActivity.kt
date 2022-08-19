package com.example.mptwitterclone.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mptwitterclone.R
import com.example.mptwitterclone.databinding.ActivityMainBinding
import com.example.mptwitterclone.feed.ui.fragments.FeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var isSnackBarDisplayed = false
    private lateinit var navController: NavController


    private val listener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            val currentDestination =
                (controller.currentDestination as FragmentNavigator.Destination).className
            hideTweetCreation(currentDestination == FeedFragment::class.java.name)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupNavigation()
        bindListeners()

    }

    private fun setupNavigation() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_content_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        setupToolbarNavigation()
        setupNavigationDrawer()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = binding.mainContent.bottomNavigation
        bottomNav.setupWithNavController(navController)
    }

    private fun setupNavigationDrawer() {
        val navView = binding.navigationView

        navController.addOnDestinationChangedListener(listener)

        navView.setupWithNavController(navController)
    }

    private fun setupToolbarNavigation() {
        //setSupportActionBar(binding.mainContent.toolbar.twitterTopToolbar)
        //appBarConfiguration = AppBarConfiguration(setOf(R.id.feed_navigation), drawerLayout)
        //setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun bindListeners() {
        setupToolbarBehaviour()
        binding.mainContent.fabNewTweet.setOnClickListener {
            navController.navigate(R.id.to_tweet_creation_global_action)
        }
    }

    private fun setupToolbarBehaviour() {
        binding.mainContent.toolbar.profileImage.setOnClickListener {
            with(binding.drawerLayout) {
                if (isOpen) close() else open()
            }
        }
    }

    private fun hideTweetCreation(isVisible: Boolean) {
        binding.mainContent.fabNewTweet.isVisible = isVisible
    }


    override fun onResume() {
        super.onResume()
        if (::navController.isInitialized) {
            navController.addOnDestinationChangedListener(listener)
        }
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }

}
