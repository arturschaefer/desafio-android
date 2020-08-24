package com.schaefer.user.domain.usecase

import com.schaefer.user.domain.model.UserDomain
import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow

class GetUsersCompose(
    val getUsersLocalUseCase: GetUsersLocalUseCase,
    val getUsersRemoteUseCase: GetUsersRemoteUseCase,
    val saveUserUseCase: SaveUserUseCase
) :
    BaseUseCase<GetUsersCompose.Params, Flow<List<UserDomain>>> {
    //TODO get users from database - UseCase
    //TODO call users from remote - UseCase
    //TODO update database with remote data - UseCase

    override suspend fun execute(params: Params?): Flow<List<UserDomain>> {
        requireNotNull(params) {
            "Failed to execute GetUserCompose. Params must not be null."
        }
        val users = getUsersRemoteUseCase.execute(GetUsersRemoteUseCase.Params(params.page))
        saveUserUseCase.execute(SaveUserUseCase.Params(users))
        return getUsersLocalUseCase.execute(GetUsersLocalUseCase.Params(params.page))
    }

    data class Params(val isFullSync: Boolean, val page: Int)
}
