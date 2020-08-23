package com.schaefer.user.domain.usecase

import com.schaefer.user.presentation.model.User
import kotlinx.coroutines.flow.Flow

class GetUsersCompose(val getUsersRemoteUseCase: GetUsersRemoteUseCase) :
    BaseUseCase<GetUsersCompose.Params,  List<User>> {
    //TODO get users from database - UseCase
    //TODO call users from remote - UseCase
    //TODO update database with remote data - UseCase

    override suspend fun execute(params: Params?): List<User> {
        requireNotNull(params) {
            "Failed to execute GetUserCompose. Params must not be null."
        }
        return getUsersRemoteUseCase.execute(GetUsersRemoteUseCase.Params(params.page))
    }

    data class Params(val isFullSync: Boolean, val page: Int)
}
