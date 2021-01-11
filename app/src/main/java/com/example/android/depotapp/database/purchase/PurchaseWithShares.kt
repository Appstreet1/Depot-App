package com.example.android.depotapp.database.purchase

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.android.depotapp.database.share.ShareDatabaseItem
import com.example.android.depotapp.model.Share

@Entity(primaryKeys = ["purchaseId", "shareId"])
data class PurchaseSharesCrossRef(
    val purchaseId: Long,
    val shareId: Long
)

data class PurchaseWithShares(
    @Embedded val purchases: PurchaseDatabaseItem,
    @Relation(
        parentColumn = "purchaseId",
        entityColumn = "shareId",
        associateBy = Junction(PurchaseSharesCrossRef::class)
    )
    val shares: List<ShareDatabaseItem>
)
