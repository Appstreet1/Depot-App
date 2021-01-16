package com.example.android.depotapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.entities.ShareDatabaseItem
import com.example.android.depotapp.model.Share

@Dao
interface ShareDao {
    @Query("SELECT * FROM shares")
    fun getShares(): LiveData<List<ShareDatabaseItem>>

    @Query("SELECT * FROM shares WHERE depotId=:id")
    fun getSharesOfDepot(id: Long): List<Share>

    @Insert
    fun addShare(share: ShareDatabaseItem)
}