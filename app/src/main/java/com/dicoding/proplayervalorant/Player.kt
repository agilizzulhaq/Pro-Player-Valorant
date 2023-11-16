package com.dicoding.proplayervalorant

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Player(
    val name: String,
    val description: String,
    val photo: Int,
    val mouse: String,
    val keyboard: String,
    val headset: String
) : Parcelable