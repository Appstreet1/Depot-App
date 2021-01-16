package com.example.android.depotapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.entities.DepotDatabaseItem

@Dao
interface DepotDao {
    @Query("SELECT * FROM depots")
    fun getAllDepots(): LiveData<List<DepotDatabaseItem>>

    @Insert
    suspend fun addDepot(depot: DepotDatabaseItem)
}