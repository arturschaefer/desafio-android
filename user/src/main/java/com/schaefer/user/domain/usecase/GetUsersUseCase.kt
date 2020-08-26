package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetUsersUseCase(private val userRepository: UserRepository) {
    fun execute(): Flow<List<UserDomain>?> {
        return userRepository.getFullSync().map { resource ->
            resource.data?.map { userEntity ->
                UserMapper.fromLocalDataToDomain(userEntity)
            }
        }
    }
}