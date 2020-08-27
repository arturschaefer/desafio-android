package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber

class GetUsersUseCase(private val userRepository: UserRepository) {
    @ExperimentalCoroutinesApi
    fun execute(): Flow<List<UserDomain>?> {
        return try {
            userRepository.getFullSync().map { resource ->
                resource.data?.map { userEntity ->
                    UserMapper.fromLocalDataToDomain(userEntity)
                }
            }
        } catch (e: Exception) {
            throw GetUsersUseCaseException(message = e.message, throwable = e)
        }
    }

    class GetUsersUseCaseException(message: String?, throwable: Throwable) :
        Exception(message, throwable)
}