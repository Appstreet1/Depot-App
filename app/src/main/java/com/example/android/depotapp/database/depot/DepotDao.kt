package com.example.android.depotapp.database.depot

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.depot.DepotWithPurchases

@Dao
interface DepotDao {
    @Query("SELECT * FROM depots")
    fun getDepots(): List<DepotDatabaseItem>

    @Transaction
    @Query("SELECT * FROM depots")
    fun getDepotsWithPurchases(): List<DepotWithPurchases>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg depots: DepotDatabaseItem)

    @Update
    fun updateDepot(depot: DepotDatabaseItem)

    @Insert
    fun addDepot(depot: DepotDatabaseItem)

    @Delete
    fun deleteDepot(depot: DepotDatabaseItem)

    @Query("DELETE FROM depots")
    fun deleteAllDepots()
}