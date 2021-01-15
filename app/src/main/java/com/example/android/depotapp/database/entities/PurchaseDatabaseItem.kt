package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Purchase
import java.util.*

@Entity(tableName = "purchases")
data class PurchaseDatabaseItem constructor(
    @PrimaryKey(autoGenerate = true)
    var purchaseId: Long,
    var titleOfShare: String,
    var amountOfShares: Double,
    var totalValue: Double,
    var dateOfPurchase: String,
    var valueIncrease: Double,
    var depotId: Long,
    val shareId: Long
)

fun List<PurchaseDatabaseItem>.parseToDomainModel(): List<Unit> {
    return map {
        Purchase(
            purchaseId = it.purchaseId,
            titleOfShare = it.titleOfShare,
            amountOfShares = it.amountOfShares,
            totalValue = it.totalValue,
            dateOfPurchase = it.dateOfPurchase,
            valueIncrease = it.valueIncrease,
            depotId = it.depotId,
            shareId = it.shareId
        )
    }
}

fun Purchase.parseToDatabaseModel(): PurchaseDatabaseItem {
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
