package com.example.android.depotapp.model

import com.example.android.depotapp.database.entities.ShareDatabaseItem

class Share(
    val id: Long,
    val symbol: String?,
    val title: String?,
    val price: Double?,
    val date: String?,
    val purchaseId: Long
)

fun Share.parseToDatabasemodel(): ShareDatabaseItem {
    return ShareDatabaseItem(
        shareId = id,
        title = title,
        date = date,
        price = price,
        symbol = symbol,
        purchaseId = purchaseId
    )
}