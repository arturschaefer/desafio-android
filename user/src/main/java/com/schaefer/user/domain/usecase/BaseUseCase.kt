package com.schaefer.user.domain.usecase

interface BaseUseCase<Params, out T> {
    suspend fun execute(params: Params? = null): T
}