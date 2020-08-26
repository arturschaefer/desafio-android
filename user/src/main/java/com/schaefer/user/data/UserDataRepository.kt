package com.schaefer.user.data

import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class UserDataRepository(
    private val userDao: UserDao,
    private val picPayService: PicPayService
) : UserRepository {
    override suspend fun getRemoteUsers(): List<UserResponse> {
        Timber.d("getRemoteUsers")
        return picPayService.getUsers()
    }

    override fun getLocalUsers(): Flow<List<UserEntity>> {
        Timber.d("getLocalUsers")
        return userDao.getAllUsers()
    }

    override suspend fun saveLocalUsers(users: List<UserResponse>) {
        Timber.d("saveLocalUsers")
        for (user in users) {
            userDao.save(UserMapper.fromRemoteToLocal(user))
        }
    }

    override fun fetchFailed(throwable: Throwable) {
        Timber.d("fetchFailed")
        Timber.e(throwable)
    }

    override fun shouldFetch(list: List<UserEntity>): Boolean {
        Timber.d("shouldFetch ${list.isNullOrEmpty()}")
        return true
    }

    @ExperimentalCoroutinesApi
    override fun getFullSync(): Flow<Resource<List<UserEntity>>> {
        return networkBoundResource(
            ::getLocalUsers,
            ::getRemoteUsers,
            ::saveLocalUsers,
            ::fetchFailed,
            ::shouldFetch
        )
    }
}