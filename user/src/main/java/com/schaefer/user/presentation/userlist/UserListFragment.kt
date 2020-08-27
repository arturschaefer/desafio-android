package com.schaefer.user.presentation.userlist

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.schaefer.ui.base.BaseFragment
import com.schaefer.user.R
import com.schaefer.ui.state.ViewState
import com.schaefer.user.presentation.userlist.adapter.UserListAdapter
import com.schaefer.ui.extensions.observe
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

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
            Timber.d(viewState.toString())
            when (viewState){
                ViewState.LOADING -> pbUserList.isVisible = true
                ViewState.LOADED -> pbUserList.isVisible = false
                ViewState.ERROR -> {
                    //TODO we need a UI for reload the data
                    pbUserList.isVisible = false
                    Toast.makeText(requireContext(), R.string.error_fetch_users, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}