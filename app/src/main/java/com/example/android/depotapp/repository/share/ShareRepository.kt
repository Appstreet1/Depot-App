package com.example.android.depotapp.repository.share

import android.util.Log
import com.example.android.depotapp.database.dao.ShareDao
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.network.StockApi
import com.example.android.depotapp.network.parseToDatabaseModel
import com.example.android.depotapp.network.parseToDomainModel
import com.example.android.depotapp.utils.NetworkResult
import com.example.android.depotapp.utils.Util.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShareRepository(private val dao: ShareDao) {

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

                val share = StockApi.retrofitService.getShareAsync(symbol, date, API_KEY).parseToDatabaseModel()

                val detail = StockApi.retrofitService.getShareDetail(symbol, API_KEY)

                share.depotId = depotId
                share.country = detail.country
                share.description = detail.description
                share.employees = detail.employees
                share.industry = detail.industry
                share.logo = detail.logo
                share.name = detail.name
                share.sector = detail.sector

                dao.addShare(share)

            } catch (e: Exception) {
                Log.i("TEST", e.toString())
            }
        }
    }

    fun getShares(depotId: Long): List<Share> {
        return dao.getSharesOfDepot(depotId)
    }
}
















