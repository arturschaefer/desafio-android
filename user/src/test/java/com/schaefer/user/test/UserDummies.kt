package com.schaefer.user.test

import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

object UserDummies {

    val userEntityDummy =
        UserEntity(
            id = 1001,
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            name = "Eduardo Santos",
            username = "@eduardo.santos"
        )

    val listOfUsers = listOf<UserResponse>(
        UserResponse(
            id = 1001,
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            name = "Eduardo Santos",
            username = "@eduardo.santos"
        ),
        UserResponse(
            id = 1020,
            img = "https://randomuser.me/api/portraits/men/54.jpg",
            name = "Juliano Garcia",
            username = "@juliano.garcia"
        )
    )

    val flowUsers: Flow<List<UserEntity>> = flow {
        listOf<UserEntity>(
            UserEntity(
                id = 1001,
                img = "https://randomuser.me/api/portraits/men/9.jpg",
                name = "Eduardo Santos",
                username = "@eduardo.santos"
            ),
            UserEntity(
                id = 1020,
                img = "https://randomuser.me/api/portraits/men/54.jpg",
                name = "Juliano Garcia",
                username = "@juliano.garcia"
            )
        )
    }
}