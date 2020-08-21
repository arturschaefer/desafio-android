package com.picpay.desafio.android.data.remote.api

import com.picpay.desafio.android.presentation.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PicPayApi {
    @GET("users")
    fun getUsers(): Call<List<User>>
}