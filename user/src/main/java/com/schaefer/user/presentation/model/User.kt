package com.schaefer.user.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long,
    val img: String,
    val name: String,
    val username: String
) : Parcelable