package com.example.android.depotapp.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "purchaseWithshares")
data class PurchaseWithShares(
    @Embedded val share: ShareDatabaseItem,
    @Relation(
        parentColumn = "shareId",
        entityColumn = "purchaseId"
    )
    val purchases: List<PurchaseDatabaseItem>
)
