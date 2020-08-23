package com.schaefer.user.data.remote.api

import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {
    @GET("users")
    suspend fun getUsers(): List<User>
}