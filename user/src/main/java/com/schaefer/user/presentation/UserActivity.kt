package com.schaefer.user.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.ui.BaseActivity
import com.schaefer.user.R
import com.schaefer.user.data.remote.source.PicPayAPI
import com.schaefer.user.presentation.model.User
import com.schaefer.user.presentation.userlist.adapter.UserListAdapter
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
