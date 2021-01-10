package com.example.android.depotapp.database.depot

import androidx.room.Embedded
import androidx.room.Relation
import com.example.android.depotapp.database.purchase.PurchaseDatabaseItem

data class DepotWithPurchases(
    @Embedded val depot: DepotDatabaseItem,
    @Relation(
        parentColumn = "id",
        entityColumn = "depotId"
    )
    val purchases: List<PurchaseDatabaseItem>

)
