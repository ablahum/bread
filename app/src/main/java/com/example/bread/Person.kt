package com.example.bread

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var name: String,
    var email: String,
    var img: Int
) : Parcelable