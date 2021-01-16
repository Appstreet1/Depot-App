package com.example.android.depotapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

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



