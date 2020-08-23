package com.schaefer.user.presentation.userlist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.schaefer.ui.BaseFragment
import com.schaefer.user.R
import com.schaefer.user.data.remote.source.PicPayAPI
import com.schaefer.user.presentation.model.User
import com.schaefer.user.presentation.state.ViewState
import com.schaefer.user.presentation.userlist.adapter.UserListAdapter
import extensions.observe
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListFragment : BaseFragment(R.layout.fragment_user_list) {
    private val userListViewModel: UserListViewModel by viewModel()

    private val userListAdapter = UserListAdapter()

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)

        rvUserList.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        userListViewModel.getUsers()
    }

    override fun setupObservers() {
        observe(userListViewModel.userList){ userList ->
            userListAdapter.users = userList
        }
        observe(userListViewModel.viewState){viewState ->
            when (viewState){
                ViewState.LOADING -> pbUserList.isVisible = true
                ViewState.LOADED -> pbUserList.isVisible = false
                ViewState.ERROR -> pbUserList.isVisible = false //TODO make a UI for error
            }
        }
    }
}