package com.example.android.depotapp.model

import android.os.Parcelable
import androidx.lifecycle.Transformations.map
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Depot(
    val id: Long = 0,
    var title: String = "",
    var value: Double = 0.0,
    var valueIncrease: Double = 0.0
) : Parcelable


fun List<Depot>.parseToDatabaseModel(): List<DepotDatabaseItem> {
    return map {
        DepotDatabaseItem(
            id = it.id,
            title = it.title,
            value = it.value,
            valueIncrease = it.valueIncrease
        )
    }
}

fun Depot.parseToDatabasemodel(): DepotDatabaseItem {
    return DepotDatabaseItem(
        id = id,
        title = title,
        value = value,
        valueIncrease = valueIncrease
    )
}