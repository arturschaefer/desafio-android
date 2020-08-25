package com.schaefer.user.presentation.userlist

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.schaefer.ui.base.BaseFragment
import com.schaefer.user.R
import com.schaefer.ui.state.ViewState
import com.schaefer.user.presentation.userlist.adapter.UserListAdapter
import com.schaefer.ui.extensions.observe
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.viewmodel.ext.android.viewModel

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