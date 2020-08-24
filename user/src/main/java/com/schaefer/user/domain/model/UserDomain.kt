package com.schaefer.user.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class UserDomain(
    val id: Long,
    val img: String,
    val name: String,
    val username: String
)