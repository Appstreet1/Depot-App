package com.example.android.depotapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.depotapp.database.entities.ShareDatabaseItem

@Dao
interface ShareDao {
    @Query("SELECT * FROM shares")
    fun getShares(): LiveData<List<ShareDatabaseItem>>

    @Insert
    fun addShare(share: ShareDatabaseItem)
}