package com.schaefer.user.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.schaefer.user.data.local.dao.UserDao
import com.schaefer.user.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "userListDb"

        fun getDatabase(context: Context): UserDatabase {
            return Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}