package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.model.UserDomain
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class SyncUsersCompose(
    val getUsersRemoteUseCase: GetUsersRemoteUseCase,
    val saveUserUseCase: SaveUserUseCase) {

    suspend fun execute() {
        try {
            val users = getUsersRemoteUseCase.execute()
            Timber.d(users.toString())
            saveUserUseCase.execute(SaveUserUseCase.Params(users))
        } catch (ex: Exception) {
            Timber.e(ex)
        }
    }
}
