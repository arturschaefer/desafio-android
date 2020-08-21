package com.picpay.desafio.android

import com.picpay.desafio.android.data.remote.api.PicPayApi
import com.picpay.desafio.android.presentation.model.User

class ExampleService(
    private val api: PicPayApi
) {

    fun example(): List<User> {
        val users = api.getUsers().execute()

        return users.body() ?: emptyList()
    }
}