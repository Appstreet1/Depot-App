package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val symbol: String?,
    val title: String?,
    val date: String?,
    var depotId: Long
)

fun List<ShareDatabaseItem>.parseToDomainModel(): List<Share> {
    return map {
        Share(
            id = it.id,
            title = it.title,
            symbol = it.symbol,
            date = it.date,
            depotId = it.depotId,
        )
    }
}

