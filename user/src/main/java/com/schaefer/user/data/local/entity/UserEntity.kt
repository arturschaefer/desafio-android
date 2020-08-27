package com.schaefer.user.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val img: String = "",
    val name: String = "",
    @ColumnInfo(name = COLUMN_USER_NAME)
    val username: String = ""
){
    companion object{
        const val TABLE_NAME = "USERS"
        const val COLUMN_USER_NAME = "user_name"
    }
}