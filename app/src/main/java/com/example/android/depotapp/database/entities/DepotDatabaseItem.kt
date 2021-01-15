package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Depot

import java.util.*

@Entity(tableName = "depots")
data class DepotDatabaseItem constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var title: String,
    var value: Double,
    var valueIncrease: Double
)

fun List<DepotDatabaseItem>.parseToDomainModel(): List<Depot> {
    return map {
        Depot(
            id = it.id,
            title = it.title,
            value = it.value,
            valueIncrease = it.valueIncrease
        )
    }
}



