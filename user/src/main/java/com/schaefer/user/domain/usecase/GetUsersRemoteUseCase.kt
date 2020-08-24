package com.schaefer.user.domain.usecase

import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.repository.UserRemoteRepository
import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow

class GetUsersRemoteUseCase(val userRemoteRepository: UserRemoteRepository) {
    suspend fun execute(): List<UserResponse> {
        return userRemoteRepository.getUsers()
    }
}
