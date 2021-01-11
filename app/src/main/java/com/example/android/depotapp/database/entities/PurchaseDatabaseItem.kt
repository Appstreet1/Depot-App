package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Purchase
import java.util.*

@Entity(tableName = "purchases")
data class PurchaseDatabaseItem constructor(
    var titleOfShare: String,
    var amountOfShares: Double,
    var totalValue: Double,
    var dateOfPurchase : Date,
    var valueIncrease: Double,
    var depotId : Long,
    var shareId: Long
){
    @PrimaryKey(autoGenerate = true)
    var purchaseId : Long = 0
}

fun List<PurchaseDatabaseItem>.parseToDomainModel(): List<Unit> {
    return map {
        Purchase(
            purchaseId = it.purchaseId,
            titleOfShare = it.titleOfShare,
            amountOfShares = it.amountOfShares,
            totalValue = it.totalValue,
            dateOfPurchase = it.dateOfPurchase,
            valueIncrease = it.valueIncrease,
            depotId = it.depotId
        )
    }
}
