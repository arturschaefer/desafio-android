package com.schaefer.user.di

import com.schaefer.user.data.local.database.UserDatabase
import com.schaefer.user.data.local.repository.UserLocalDataRepository
import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.data.remote.repository.UserRemoteDataRepository
import com.schaefer.user.data.remote.source.PicPayAPI
import com.schaefer.user.domain.repository.UserLocalRepository
import com.schaefer.user.domain.repository.UserRemoteRepository
import com.schaefer.user.domain.usecase.GetUsersCompose
import com.schaefer.user.domain.usecase.GetUsersLocalUseCase
import com.schaefer.user.domain.usecase.GetUsersRemoteUseCase
import com.schaefer.user.domain.usecase.SaveUserUseCase
import com.schaefer.user.presentation.userlist.UserListViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val userModule: Module = module {
    //region - Service
    single { OkHttpClient() }
    single { PicPayAPI(okHttpClient = get()) }
    single<PicPayService> { PicPayAPI(okHttpClient = get()).getPicPayService() }
    //endregion

    //region - Repositories
    factory<UserRemoteRepository> { UserRemoteDataRepository(picPayService = get()) }
    factory<UserLocalRepository> { UserLocalDataRepository(userDao = get()) }
    //endregion

    //region - Room
    single { UserDatabase.getDatabase(context = androidContext()) }
    single { get<UserDatabase>().getUserDao() }
    //endregion

    //region - UseCases
    factory { GetUsersRemoteUseCase(userRemoteRepository = get()) }
    factory { GetUsersLocalUseCase(userLocalRepository = get()) }
    factory { SaveUserUseCase(userLocalRepository = get()) }
    factory {
        GetUsersCompose(
            getUsersRemoteUseCase = get(),
            getUsersLocalUseCase = get(),
            saveUserUseCase = get()
        )
    }
    //endregion

    //region - ViewModels
    viewModel { UserListViewModel(getUsersCompose = get()) }
    //endregion
}