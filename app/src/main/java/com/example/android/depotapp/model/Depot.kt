package com.example.android.depotapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Depot(
    val id: Long,
    var title: String,
    var value: Double,
    var valueIncrease: Double
) : Parcelable