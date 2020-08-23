package com.schaefer.user.data.remote.repository

import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.domain.repository.UserRemoteRepository
import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class UserRemoteDataRepository(val picPayService: PicPayService) : UserRemoteRepository{
    override suspend fun getUsers():List<User> {
        return picPayService.getUsers()
    }

}