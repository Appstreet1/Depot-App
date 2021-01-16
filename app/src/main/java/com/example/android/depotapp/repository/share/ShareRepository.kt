package com.example.android.depotapp.repository.share

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.model.parseToDatabasemodel
import com.example.android.depotapp.network.StockApi
import com.example.android.depotapp.network.parseToDatabaseModel
import com.example.android.depotapp.network.parseToDomainModel
import com.example.android.depotapp.utils.NetworkResult
import com.example.android.depotapp.utils.const.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShareRepository(private val dao: ShareDao) {

    val shares: LiveData<List<Share>> = Transformations.map(dao.getShares()) {
        it.parseToDomainModel()
    }

    suspend fun requestShare(symbol: String, date: String): NetworkResult {
        return try {
            val share = StockApi.retrofitService.getShareAsync(symbol, date, API_KEY)

            share.parseToDomainModel()

            NetworkResult.Success(share)
        } catch (e: Exception) {

            NetworkResult.Error(e)
        }
    }

    suspend fun addShare(symbol: String, date: String, depotId: Long) {
        withContext(Dispatchers.IO) {

            try {

                val data = StockApi.retrofitService.getShareAsync(symbol, date, API_KEY)
                val shareData = data.parseToDatabaseModel()

                shareData.depotId = depotId

                dao.addShare(shareData)

            } catch (e: Exception) {
                Log.i("TEST", e.toString())
            }
        }
    }

     fun getShares(depotId: Long): List<Share> {
        return dao.getSharesOfDepot(depotId)
    }
}
















