package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    var title: String?,
    var symbol: String?,
    var price: Double?,
    var date: String?
) {
    @PrimaryKey(autoGenerate = true)
    var shareId: Long = 0
}

fun List<ShareDatabaseItem>.parseToDomainModel(): List<Share> {
    return map {
        Share(
            shareId = it.shareId,
            title = it.title,
            symbol = it.symbol,
            price = it.price,
            date = it.date
        )
    }
}

