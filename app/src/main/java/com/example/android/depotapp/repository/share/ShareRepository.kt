package com.example.android.depotapp.repository.share

import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.database.entities.ShareDatabaseItem

class ShareRepository(private val dao: ShareDao) {

    val shares = dao.getShares()

    suspend fun insertAll(shares: ShareDatabaseItem) {
        dao.insertAll(shares)
    }

    suspend fun deleteAll() {
        dao.deleteAllShares()
    }

    suspend fun addShare(share: ShareDatabaseItem) {
        dao.addShare(share)
    }
}