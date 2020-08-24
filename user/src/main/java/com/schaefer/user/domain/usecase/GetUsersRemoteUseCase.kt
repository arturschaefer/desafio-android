package com.schaefer.user.domain.usecase

import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.repository.UserRemoteRepository
import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow

class GetUsersRemoteUseCase(val userRemoteRepository: UserRemoteRepository) :
    BaseUseCase<GetUsersRemoteUseCase.Params, List<UserResponse>>{

    override suspend fun execute(params: Params?): List<UserResponse> {
        requireNotNull(params) {
            "Failed to execute GetUsersRemoteUseCase. Params must not be null."
        }
        return userRemoteRepository.getUsers()
    }

    data class Params(val page: Int)
}
