package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    @PrimaryKey
    var symbol: String?,
    var title: String?,
    var price: Double?,
    var date: String?
)

fun List<ShareDatabaseItem>.parseToDomainModel(): List<Share> {
    return map {
        Share(
            title = it.title,
            symbol = it.symbol,
            price = it.price,
            date = it.date
        )
    }
}

