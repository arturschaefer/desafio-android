package com.schaefer.user.presentation.state

sealed class ViewState {
    object LOADING : ViewState()
    object LOADED : ViewState()
    object ERROR : ViewState()
}