package com.schaefer.user.data

import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retry
import timber.log.Timber

class UserDataRepository(
    private val userDao: UserDao,
    private val picPayService: PicPayService,
    private val dispatcher: CoroutineDispatcher
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

    @Throws
    override fun fetchFailed(throwable: Throwable) {
        Timber.e(throwable)
        throw throwable
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
        ).retry(MAX_RETRIES) { throwable ->
            (throwable is Exception).also { if (it) delay(MILLIS_DELAY_TO_RETRY) }
        }.flowOn(dispatcher)
    }

    companion object {
        const val MAX_RETRIES = 2L
        const val MILLIS_DELAY_TO_RETRY = 1000L
    }
}