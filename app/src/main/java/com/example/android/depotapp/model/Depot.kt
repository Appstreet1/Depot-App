package com.example.android.depotapp.model

import android.os.Parcelable
import androidx.lifecycle.Transformations.map
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Depot(
    val id: Long,
    var title: String,
    var value: Double,
    var valueIncrease: Double
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