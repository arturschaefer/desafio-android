package com.schaefer.user.domain.repository

import com.schaefer.user.data.Resource
import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getLocalUsers(): Flow<List<UserEntity>>
    fun getFullSync(): Flow<Resource<List<UserEntity>>>
    suspend fun getRemoteUsers(): List<UserResponse>
    suspend fun saveLocalUsers(users: List<UserResponse>)
    fun shouldFetch(list: List<UserEntity>): Boolean
    fun fetchFailed(throwable: Throwable)
}