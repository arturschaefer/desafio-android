package com.schaefer.ui.state

sealed class ViewState {
    object LOADING : ViewState()
    object LOADED : ViewState()
    object ERROR : ViewState()
}