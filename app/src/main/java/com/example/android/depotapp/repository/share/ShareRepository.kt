package com.example.android.depotapp.repository.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.model.parseToDatabasemodel
import com.example.android.depotapp.network.StockApi
import com.example.android.depotapp.network.parseToDomainModel
import com.example.android.depotapp.utils.NetworkResult
import com.example.android.depotapp.utils.const.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShareRepository(private val dao: ShareDao) {

    val shares: LiveData<List<Share>> = Transformations.map(dao.getShares()) {
        it.parseToDomainModel()
    }

    suspend fun requestShareBySymbolAndDate(symbol: String, date: String): NetworkResult {
        return try {
            val share = StockApi.retrofitService.getShare(symbol, date, API_KEY)

            share.parseToDomainModel()
            NetworkResult.Success(share)
        } catch (e: Exception) {

            NetworkResult.Error(e)
        }
    }

    suspend fun getShareBySymbolAndDate(symbol: String, date: String): Share {
        return StockApi.retrofitService.getShare(symbol, date, API_KEY).parseToDomainModel()
    }

    suspend fun getTitleBySymbol(symbol: String): String {

        return StockApi.retrofitService.getShareTitleBySymbol(symbol, API_KEY).title
    }

    suspend fun addShare(share: Share) {
        withContext(Dispatchers.IO) {
            dao.addShare(share.parseToDatabasemodel())
        }
    }
}