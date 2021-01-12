package com.example.android.depotapp.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class DepotWithPurchases(
    @Embedded val depot: DepotDatabaseItem,
    @Relation(
        parentColumn = "id",
        entityColumn = "depotId"
    )
    val purchases: List<PurchaseDatabaseItem>
)
