package com.lucas.marvellist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lucas.marvellist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val bottomNavigationScreensIds = setOf(
        R.id.navigation_hero_list,
        R.id.navigation_events
    )

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()

        setupNavigation()
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(bottomNavigationScreensIds)

        binding.apply {
            setSupportActionBar(toolbar)
            setupActionBarWithNavController(navController, appBarConfiguration)

            bottomNavView.let {
                it.setupWithNavController(navController)
                it.itemIconTintList = null
                navController.addOnDestinationChangedListener { _, destination, _ ->

                    it.visibility =
                        if (bottomNavigationScreensIds.contains(destination.id))
                            View.VISIBLE else View.GONE
                }
            }
        }
    }

    fun setupView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}