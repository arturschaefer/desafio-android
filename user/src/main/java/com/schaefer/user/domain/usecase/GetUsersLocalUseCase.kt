package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserLocalRepository
import kotlinx.coroutines.flow.Flow

class GetUsersLocalUseCase(private val userLocalRepository: UserLocalRepository) :
    BaseUseCase<GetUsersLocalUseCase.Params, Flow<List<UserDomain>>> {

    override suspend fun execute(params: Params?): Flow<List<UserDomain>> {
        requireNotNull(params) {
            "Failed to execute GetUsersRemoteUseCase. Params must not be null."
        }
        return userLocalRepository.getUsers()
    }

    data class Params(val page: Int)
}