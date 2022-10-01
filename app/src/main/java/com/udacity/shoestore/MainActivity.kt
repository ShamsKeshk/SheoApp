package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = getAppBarConfiguration()
        binding.toolbar.setupWithNavController(navController, getAppBarConfiguration())
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener { _ ->
            NavigationUI.navigateUp(navController, appBarConfiguration) }
    }

    private fun getAppBarConfiguration(): AppBarConfiguration{
        return AppBarConfiguration(
            setOf(
                R.id.welcomeScreenFragment,
                R.id.shoesListFragment,
                R.id.loginFragment2
            )
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return (findNavController(this, R.id.nav_host_fragment).navigateUp()
                || super.onSupportNavigateUp())
    }
}
