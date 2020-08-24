package com.schaefer.user.presentation

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.schaefer.ui.base.BaseActivity
import com.schaefer.user.R

class UserActivity : BaseActivity(R.layout.activity_main) {
    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment).navController
        navController.apply {
            setGraph(
                R.navigation.user_navigation
            )
        }
    }
}
