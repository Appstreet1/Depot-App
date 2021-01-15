package com.example.android.depotapp.model

import com.example.android.depotapp.database.entities.ShareDatabaseItem

class Share(
    val id: Long,
    val symbol: String?,
    val title: String?,
    val price: Double?,
    val date: String?,
    val amount: Double?,
    val totalValue: Double?,
    val depotId: Long
)

fun Share.parseToDatabasemodel(): ShareDatabaseItem {
    return ShareDatabaseItem(
        id = id,
        title = title,
        date = date,
        price = price,
        symbol = symbol,
        depotId = depotId,
        amount = amount,
        totalValue = totalValue
    )
}