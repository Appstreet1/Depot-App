package com.example.android.depotapp.repository.depot

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.database.entities.DepotWithPurchases
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.parseToDatabaseModel
import com.example.android.depotapp.model.parseToDatabasemodel
import kotlinx.coroutines.*

class DepotRepository(private val dao: DepotDao) {

    val allDepots: LiveData<List<Depot>> = Transformations.map(dao.getAllDepots()) {
        it.parseToDomainModel()
    }

    suspend fun addDepot(depot: Depot) {
        withContext(Dispatchers.IO) {
            dao.addDepot(depot.parseToDatabasemodel())
        }
    }

//    suspend fun getDepotWithPurchases(depotId : Long) : DepotWithPurchases {
//        return dao.getDepotsWithPurchases(depotId)
//    }

    suspend fun updateDepot(depot: DepotDatabaseItem) {
        withContext(Dispatchers.IO) {
            dao.updateDepot(depot)
        }
    }

    suspend fun deleteDepot(depot: Depot) {
        withContext(Dispatchers.IO) {
            dao.deleteDepot(depot.parseToDatabasemodel())
        }
    }

    suspend fun deleteAllDepots() {
        withContext(Dispatchers.IO) {
            dao.deleteAllDepots()
        }
    }
}