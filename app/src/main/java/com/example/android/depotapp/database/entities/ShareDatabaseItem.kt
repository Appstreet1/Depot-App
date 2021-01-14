package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    @PrimaryKey
    val shareId: Long,
    val symbol: String?,
    var title: String?,
    var price: Double?,
    var date: String?,
    val purchaseId: Long
)

fun List<ShareDatabaseItem>.parseToDomainModel(): List<Share> {
    return map {
        Share(
            id = it.shareId,
            title = it.title,
            symbol = it.symbol,
            price = it.price,
            date = it.date,
            purchaseId = it.purchaseId
        )
    }
}

