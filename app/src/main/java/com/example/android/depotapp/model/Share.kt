package com.example.android.depotapp.model

import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.database.entities.ShareDatabaseItem

class Share(
    val symbol : String?,
    val title: String?,
    val price: Double?,
    val date: String?
)

fun Share.parseToDatabasemodel(): ShareDatabaseItem {
    return DepotDatabaseItem(
        id = id,
        title = title,
        value = value,
        valueIncrease = valueIncrease
    )
}