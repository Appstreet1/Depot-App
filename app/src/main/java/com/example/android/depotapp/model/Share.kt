package com.example.android.depotapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Share(
    val id: Long,
    val symbol: String,
    val date: String,
    var depotId: Long,
    var logo : String,
    val country: String,
    val industry: String,
    val sector: String,
    val description: String,
    val name: String,
    val employees: String
) : Parcelable
