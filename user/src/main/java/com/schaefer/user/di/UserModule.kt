package com.schaefer.user.di

import com.schaefer.user.data.remote.source.PicPayAPI
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val userModule: Module = module {
    single { OkHttpClient() }
    single { PicPayAPI(okHttpClient = get()) }
}