package com.schaefer.user.domain.repository

interface UserLocalRepository {
    fun getUsers()
    fun saveUsers()
}