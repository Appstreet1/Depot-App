package com.example.android.depotapp.database.purchase

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Purchase
import java.util.*

@Entity(tableName = "purchases")
data class PurchaseDatabaseItem constructor(
    val titleOfShare: String,
    val amountOfShares: Double,
    val totalValue: Double,
    val dateOfPurchase : Date,
    val valueIncrease: Double,
    val depotId : Long
){
    @PrimaryKey(autoGenerate = true)
    val purchaseId : Long = 0
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
