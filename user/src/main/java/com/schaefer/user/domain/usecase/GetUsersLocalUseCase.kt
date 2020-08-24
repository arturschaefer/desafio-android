package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetUsersLocalUseCase(private val userLocalRepository: UserLocalRepository) {
     suspend fun execute(): Flow<List<UserDomain>> {
        return userLocalRepository.getUsers().map { users ->
            users.map { user ->
                UserMapper.fromLocalData(user)
            }
        }
    }
}