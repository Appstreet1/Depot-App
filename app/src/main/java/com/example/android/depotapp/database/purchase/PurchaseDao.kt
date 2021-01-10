package com.example.android.depotapp.database.purchase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.share.ShareDatabaseItem

@Dao
interface PurchaseDao {
    @Query("SELECT * FROM purchases")
    fun getPurchases() : List<PurchaseDatabaseItem>

    @Transaction
    @Query("SELECT * FROM purchases")
    fun getPurchasesWithShares(): LiveData<List<PurchaseWithShares>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg shares: ShareDatabaseItem)

    @Insert
    fun addPurchase(purchase : PurchaseDatabaseItem)

    @Delete
    fun deletePurchase(purchase: PurchaseDatabaseItem)

    @Query("DELETE FROM purchases")
    fun deleteAllPurchases()
}