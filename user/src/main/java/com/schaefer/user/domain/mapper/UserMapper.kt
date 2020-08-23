package com.schaefer.user.domain.mapper

import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.presentation.model.User

object UserMapper{
    fun toPresentation(user: UserResponse): User{
        return User(
            img = user.img,
            name = user.name,
            username = user.username,
            id = user.id
        )
    }
}