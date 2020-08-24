package com.schaefer.user.domain.usecase

import com.schaefer.user.data.local.entity.UserEntity
import com.schaefer.user.data.remote.model.UserResponse
import com.schaefer.user.domain.mapper.UserMapper
import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.domain.repository.UserLocalRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.lang.Exception

class SaveUserUseCase(private val userLocalRepository: UserLocalRepository) :
    BaseUseCase<SaveUserUseCase.Params, Boolean> {

    override suspend fun execute(params: Params?): Boolean {
        requireNotNull(params) {
            "Failed to execute SaveUserUseCase. Params must not be null."
        }
        return try {
            userLocalRepository.saveUsers(params.users)
            true
        } catch (ex: Exception){
            Timber.e(ex)
            false
        }
    }

    data class Params(val users: List<UserResponse>)
}