package com.schaefer.user.test

import com.schaefer.user.data.local.entity.UserEntity

object UserDummies {

    val userEntityDummy =
        UserEntity(
            id = 1001,
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            name = "Eduardo Santos",
            username = "@eduardo.santos"
        )
}