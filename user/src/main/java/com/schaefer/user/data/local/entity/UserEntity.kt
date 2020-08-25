package com.schaefer.user.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey
    var id: Long,
    val img: String,
    val name: String,
    val username: String
){
    companion object{
        const val TABLE_NAME = "USERS"
    }
}