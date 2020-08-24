package com.picpay.desafio.android

import android.app.Application
import com.facebook.stetho.Stetho
import com.picpay.desafio.android.di.picPayModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class PicPayApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PicPayApplication)
            modules(picPayModules)
        }

        Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}