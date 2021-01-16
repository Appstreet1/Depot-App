package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Share

@Entity(tableName = "shares")
data class ShareDatabaseItem constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val symbol: String,
    val date: String,
    var depotId: Long,
    var logo: String,
    var country: String,
    var industry: String,
    var sector: String,
    var description: String,
    var name: String,
    var employees: String
)

fun List<ShareDatabaseItem>.parseToDomainModel(): List<Share> {
    return map {
        Share(
            id = it.id,
            symbol = it.symbol,
            date = it.date,
            depotId = it.depotId,
            logo = it.logo,
            country = it.country,
            industry = it.industry,
            sector = it.sector,
            description = it.description,
            name = it.name,
            employees = it.employees
        )
    }
}



