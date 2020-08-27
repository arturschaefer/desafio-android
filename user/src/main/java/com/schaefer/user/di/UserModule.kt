package com.schaefer.user.di

import com.schaefer.user.data.UserDataRepository
import com.schaefer.user.data.local.database.UserDatabase
import com.schaefer.user.data.remote.api.PicPayService
import com.schaefer.user.data.remote.source.PicPayAPI
import com.schaefer.user.domain.repository.UserRepository
import com.schaefer.user.domain.usecase.GetUsersUseCase
import com.schaefer.user.presentation.userlist.UserListViewModel
import kotlinx.coroutines.Dispatchers
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
    factory<UserRepository> {
        UserDataRepository(
            picPayService = get(),
            userDao = get(),
            dispatcher = Dispatchers.IO
        )
    }
    //endregion

    //region - Room
    single { UserDatabase.getDatabase(context = androidContext()) }
    single { get<UserDatabase>().getUserDao() }
    //endregion

    //region - UseCases
    factory { GetUsersUseCase(userRepository = get()) }
    //endregion

    //region - ViewModels
    viewModel { UserListViewModel(getUsersUseCase = get()) }
    //endregion
}