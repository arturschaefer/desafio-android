package com.schaefer.user.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.schaefer.user.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(user: UserEntity)

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME}")
    fun getAllUsers(): Flow<List<UserEntity>>
}