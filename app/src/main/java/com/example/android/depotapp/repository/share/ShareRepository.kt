package com.example.android.depot.repository.share

import com.example.android.depot.db.share.ShareDao
import com.example.android.depot.db.share.ShareDatabaseItem

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