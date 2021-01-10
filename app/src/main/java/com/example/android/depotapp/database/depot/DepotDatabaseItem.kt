package com.example.android.depotapp.database.depot

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase

import java.util.*

@Entity(tableName = "depots")
data class DepotDatabaseItem constructor(
    val title: String,
    val purchases: List<Purchase>,
    val value: Double,
    val valueIncrease: Double
){
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}

fun List<DepotDatabaseItem>.parseToDomainModel(): List<Depot> {
    return map {
        Depot(
            id = it.id,
            title = it.title,
            purchases = it.purchases,
            value = it.value,
            valueIncrease = it.valueIncrease
        )
    }
}

