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
    @Query("SELECT * FROM depots WHERE id=:id")
    suspend fun getDepotsWithPurchases(id: Long): DepotWithPurchases

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg depots: DepotDatabaseItem)

//    @Query("SELECT * FROM depots ")
//    fun getDepotById(id : Long) : DepotDatabaseItem

    @Update
    suspend fun updateDepot(depot: DepotDatabaseItem)

    @Insert
    suspend fun addDepot(depot: DepotDatabaseItem)

    @Delete
    suspend fun deleteDepot(depot: DepotDatabaseItem)

    @Query("DELETE FROM depots")
    suspend fun deleteAllDepots()
}