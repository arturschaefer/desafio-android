package com.schaefer.user.data.local.repository

import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserLocalDataRepository(
    private val userDao: UserDao
) : UserLocalRepository {

    override suspend fun getUsers(): Flow<List<UserDomain>> {
        return userDao.getAllUsers().map { users ->
            users.map { user ->
                UserMapper.fromLocalData(user)
            }
        }
    }

    override suspend fun saveUsers(users: List<UserResponse>) {
        for (user in users) {
            userDao.save(UserMapper.toLocalData(user))
        }
    }

}