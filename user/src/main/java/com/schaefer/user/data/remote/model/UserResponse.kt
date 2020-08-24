package com.schaefer.user.data.remote.model

import com.squareup.moshi.Json

data class UserResponse(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "img") val img: String,
    @field:Json(name = "username") val username: String
)