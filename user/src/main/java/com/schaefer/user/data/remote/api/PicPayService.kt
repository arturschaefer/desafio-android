package com.schaefer.user.data.remote.api

import com.schaefer.user.presentation.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}