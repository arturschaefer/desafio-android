package com.schaefer.user.data.remote.source

import com.schaefer.user.BuildConfig
import com.schaefer.user.data.remote.api.PicPayService
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PicPayAPI(private val okHttpClient: OkHttpClient) {
    private val url = BuildConfig.BASE_URL

    fun getPicPayService(): PicPayService = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(PicPayService::class.java)
}