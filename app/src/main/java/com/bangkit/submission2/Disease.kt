package com.bangkit.submission2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Disease(
    val name: String,
    val description: String,
    val photo: String,
    val date: String,
    val cause:String
) : Parcelable