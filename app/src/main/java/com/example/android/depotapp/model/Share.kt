package com.example.android.depotapp.model

import android.os.Parcelable
import com.example.android.depotapp.database.entities.ShareDatabaseItem
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

fun Share.parseToDatabasemodel(): ShareDatabaseItem {
    return ShareDatabaseItem(
        id = id,
        date = date,
        symbol = symbol,
        depotId = depotId,
        logo = logo,
        country = country,
        industry = industry,
        sector = sector,
        description = description,
        name = name,
        employees = employees
    )
}