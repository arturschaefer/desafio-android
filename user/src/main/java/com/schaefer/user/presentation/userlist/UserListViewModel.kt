package com.schaefer.user.presentation.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.usecase.SyncUsersCompose
import com.schaefer.user.presentation.model.User
import com.schaefer.ui.state.ViewState
import com.schaefer.ui.extensions.toLiveData
import com.schaefer.user.domain.usecase.GetUsersLocalUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class UserListViewModel(
    private val syncUsersCompose: SyncUsersCompose,
    private val getUsersLocalUseCase: GetUsersLocalUseCase
) : ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList = _userList.toLiveData()

    private val _viewState = MutableLiveData<ViewState>()
    val viewState = _viewState.toLiveData()

    fun getUsers() {
        _viewState.postValue(ViewState.LOADING)
        viewModelScope.launch {
            try {
                getUsersLocalUseCase.execute()
                .collect { users ->
                    val userResult = users.map { user -> UserMapper.toPresentation(user) }
                    _userList.postValue(userResult)
                    if (userResult.isNotEmpty()) {
                        _viewState.postValue(ViewState.LOADED)
                    }
                }
            } catch (ex: Exception) {
                _viewState.postValue(ViewState.ERROR)
                Timber.d(ex.toString())
            }
        }
    }

    fun syncUsers(){
        viewModelScope.launch {
            syncUsersCompose.execute()
        }
    }
}