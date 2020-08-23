package com.schaefer.user.presentation.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schaefer.user.domain.usecase.GetUsersCompose
import com.schaefer.user.presentation.model.User
import com.schaefer.user.presentation.state.ViewState
import extensions.toLiveData
import kotlinx.coroutines.launch
import timber.log.Timber

class UserListViewModel(
    private val getUsersCompose: GetUsersCompose
) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList = _userList.toLiveData()

    private val _viewState = MutableLiveData<ViewState>()
    val viewState = _viewState.toLiveData()

    fun getUsers() {
        _viewState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            try {
                _userList.postValue(
                    getUsersCompose.execute(
                        GetUsersCompose.Params(
                            isFullSync = true,
                            page = 0
                        )
                    )
                )
                _viewState.postValue(ViewState.LOADED)
            } catch (ex: Exception) {
                _viewState.postValue(ViewState.ERROR)
                Timber.d(ex.toString())
            }
        }
    }
}