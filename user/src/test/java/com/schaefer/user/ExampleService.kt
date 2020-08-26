package com.schaefer.user

import com.schaefer.user.data.remote.api.PicPayApi
import com.schaefer.user.presentation.model.User

class ExampleService(
    private val api: PicPayApi
) {

    fun example(): List<User> {
        val users = api.getUsers().execute()

        return users.body() ?: emptyList()
    }
}