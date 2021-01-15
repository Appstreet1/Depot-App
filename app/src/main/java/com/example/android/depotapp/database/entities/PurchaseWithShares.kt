package com.example.android.depotapp.database.entities

import androidx.room.Embedded
import androidx.room.Relation


data class PurchaseWithShares(
    @Embedded val share: ShareDatabaseItem,
    @Relation(
        parentColumn = "shareId",
        entityColumn = "purchaseId"
    )
    val purchases: List<PurchaseDatabaseItem>
)
