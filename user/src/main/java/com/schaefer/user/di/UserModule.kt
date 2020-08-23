package com.schaefer.user.di

import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.data.remote.repository.UserRemoteDataRepository
import com.schaefer.user.data.remote.source.PicPayAPI
import com.schaefer.user.domain.repository.UserRemoteRepository
import com.schaefer.user.domain.usecase.GetUsersCompose
import com.schaefer.user.domain.usecase.GetUsersRemoteUseCase
import com.schaefer.user.presentation.userlist.UserListViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val userModule: Module = module {
    single { OkHttpClient() }
    single { PicPayAPI(okHttpClient = get()) }
    single<PicPayService> { PicPayAPI(okHttpClient = get()).getPicPayService() }

    factory<UserRemoteRepository> { UserRemoteDataRepository(picPayService = get()) }
    factory { GetUsersRemoteUseCase(userRemoteRepository = get()) }
    factory { GetUsersCompose(getUsersRemoteUseCase = get()) }

    viewModel { UserListViewModel(getUsersCompose = get()) }
}