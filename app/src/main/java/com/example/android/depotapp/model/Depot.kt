package com.example.android.depotapp.model

import android.os.Parcelable
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Depot(
    val id: Long = 0,
    var title: String = "",
    var value: Double = 0.0,
    var valueIncrease: Double = 0.0
) : Parcelable



fun Depot.parseToDatabasemodel(): DepotDatabaseItem {
    return DepotDatabaseItem(
        id = id,
        title = title,
        value = value,
        valueIncrease = valueIncrease
    )
}