package com.example.android.depotapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.entities.PurchaseDatabaseItem
import com.example.android.depotapp.database.entities.ShareDatabaseItem
import com.example.android.depotapp.model.Purchase

@Dao
interface PurchaseDao {
    @Query("SELECT * FROM purchases")
    fun getPurchases(): LiveData<List<PurchaseDatabaseItem>>

    @Query("SELECT * FROM purchases WHERE depotId=:depotId")
    fun getPurchasesByDepotId(depotId: Long): List<Purchase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg shares: ShareDatabaseItem)

    @Insert
    fun addPurchase(purchase: PurchaseDatabaseItem)

    @Delete
    fun deletePurchase(purchase: PurchaseDatabaseItem)

    @Query("DELETE FROM purchases")
    fun deleteAllPurchases()
}