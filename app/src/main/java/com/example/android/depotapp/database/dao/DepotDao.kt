package com.example.android.depotapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.entities.DepotWithPurchases
import com.example.android.depotapp.database.entities.DepotDatabaseItem

@Dao
interface DepotDao {
    @Query("SELECT * FROM depots")
    fun getAllDepots(): LiveData<List<DepotDatabaseItem>>

    @Transaction
    @Query("SELECT * FROM depots")
    suspend fun getDepotsWithPurchases(): List<DepotWithPurchases>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg depots: DepotDatabaseItem)

    @Update
    suspend fun updateDepot(depot: DepotDatabaseItem)

    @Insert
    suspend fun addDepot(depot: List<DepotDatabaseItem>)

    @Delete
    suspend fun deleteDepot(depot: DepotDatabaseItem)

    @Query("DELETE FROM depots")
    suspend fun deleteAllDepots()
}