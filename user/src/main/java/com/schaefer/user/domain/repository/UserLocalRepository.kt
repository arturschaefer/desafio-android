package com.schaefer.user.domain.repository

import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow

interface UserLocalRepository {
    suspend fun getUsers(): Flow<List<UserDomain>>
    suspend fun saveUsers(users: List<UserResponse>)
}