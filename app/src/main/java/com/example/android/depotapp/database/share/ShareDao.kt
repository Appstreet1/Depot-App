package com.example.android.depotapp.database.share

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShareDao {
    @Query("SELECT * FROM shares")
    fun getShares(): LiveData<List<ShareDatabaseItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg shares: ShareDatabaseItem)


    //Test
    @Delete
    fun deleteShare(share: ShareDatabaseItem)

    @Query("DELETE FROM shares")
    fun deleteAllShares()

    @Insert
    fun addShare(share: ShareDatabaseItem)

}