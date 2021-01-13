package com.example.android.depotapp.repository.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.BuildConfig
import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.database.entities.ShareDatabaseItem
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.network.StockApi
import com.example.android.depotapp.network.parseToDatabaseModel
import com.example.android.depotapp.utils.const
import com.example.android.depotapp.utils.const.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShareRepository(private val dao: ShareDao) {

    val shares: LiveData<List<Share>> = Transformations.map(dao.getShares()) {
        it.parseToDomainModel()
    }

    suspend fun deleteAll() {
        dao.deleteAllShares()
    }

    suspend fun getShareBySymbolAndDate(symbol: String, date: String){
        withContext(Dispatchers.IO){
            val share = StockApi.retrofitService.getShare(symbol, date, API_KEY)
        }
    }

    suspend fun addShare(share: ShareDatabaseItem) {
        withContext(Dispatchers.IO) {
            dao.addShare(share)
        }
    }
}