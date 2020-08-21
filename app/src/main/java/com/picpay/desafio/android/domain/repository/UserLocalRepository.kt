package com.picpay.desafio.android.domain.repository

interface UserLocalRepository {
    fun getUsers()
    fun saveUsers()
}