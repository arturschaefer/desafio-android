package com.picpay.desafio.android.di

import com.schaefer.user.di.userModule
import org.koin.core.module.Module

val picPayModules = listOf<Module>(
    userModule
)