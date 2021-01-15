package com.example.android.depotapp.model

import com.example.android.depotapp.database.entities.PurchaseDatabaseItem
import com.example.android.depotapp.database.entities.ShareDatabaseItem
import java.util.*

class Purchase(
    val purchaseId: Long,
    val titleOfShare: String,
    val amountOfShares: Double,
    val totalValue: Double,
    val dateOfPurchase: String,
    val valueIncrease: Double,
    val depotId: Long,
    val shareId: Long
)

fun Purchase.parseToDatabasemodel(): PurchaseDatabaseItem {
    return PurchaseDatabaseItem(
        purchaseId = purchaseId,
        titleOfShare = titleOfShare,
        amountOfShares = amountOfShares,
        totalValue = totalValue,
        dateOfPurchase = dateOfPurchase,
        valueIncrease = valueIncrease,
        depotId = depotId,
        shareId = shareId
    )
}