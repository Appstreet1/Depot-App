package com.example.android.depotapp.repository.depot

import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.utils.DataResult
import kotlinx.coroutines.*

class DepotRepository(private val dao: DepotDao) {

    suspend fun getDepots() {
        withContext(Dispatchers.IO) {
            dao.getDepots()
        }
    }

    suspend fun addDepot(depot: DepotDatabaseItem) {
        withContext(Dispatchers.IO) {
            dao.addDepot(depot)
        }
    }

    suspend fun updateDepot(depot: DepotDatabaseItem) {
        withContext(Dispatchers.IO) {
            dao.updateDepot(depot)
        }
    }

    suspend fun deleteDepot(depot: DepotDatabaseItem) {
        withContext(Dispatchers.IO) {
            dao.deleteDepot(depot)
        }
    }

    suspend fun deleteAllDepots() {
        withContext(Dispatchers.IO) {
            dao.deleteAllDepots()
        }
    }
}