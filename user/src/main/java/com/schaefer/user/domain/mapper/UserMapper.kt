package com.schaefer.user.domain.mapper

import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.presentation.model.User

object UserMapper{
    fun fromLocalDataToDomain(user: UserEntity): UserDomain{
        return UserDomain(
            img = user.img,
            name = user.name,
            username = user.username,
            id = user.id
        )
    }

    fun fromRemoteToLocal(user: UserResponse): UserEntity{
        return UserEntity(
            img = user.img,
            name = user.name,
            username = user.username,
            id = user.id
        )
    }

    fun fromDomainToPresentation(user: UserDomain): User{
        return User(
            img = user.img,
            name = user.name,
            username = user.username,
            id = user.id
        )
    }
}