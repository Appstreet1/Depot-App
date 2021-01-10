package com.example.android.depotapp.database.share

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    @PrimaryKey(autoGenerate = true)
    val shareId : String,
    val title: String,
    val symbol : String,
    val price : Double,
    val date: String
)

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

