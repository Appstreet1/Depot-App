package com.example.android.depotapp.model

import android.os.Parcelable
import com.example.android.depotapp.database.entities.ShareDatabaseItem
import kotlinx.android.parcel.Parcelize

@Parcelize
class Share(
    val id: Long,
    val symbol: String?,
    val title: String?,
    val date: String?,
    var depotId: Long
) : Parcelable

fun Share.parseToDatabasemodel(): ShareDatabaseItem {
    return ShareDatabaseItem(
        id = id,
        title = title,
        date = date,
        symbol = symbol,
        depotId = depotId,
    )
}