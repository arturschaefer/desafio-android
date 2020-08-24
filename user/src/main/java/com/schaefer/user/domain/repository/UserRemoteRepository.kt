package com.schaefer.user.domain.repository

import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow

interface UserRemoteRepository{
    suspend fun getUsers(): List<UserResponse>
}