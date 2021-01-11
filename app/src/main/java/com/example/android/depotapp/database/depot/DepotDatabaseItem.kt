package com.example.android.depotapp.database.depot

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase

import java.util.*

@Entity(tableName = "depots")
data class DepotDatabaseItem constructor(
    var title: String,
    var value: Double,
    var valueIncrease: Double
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

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

