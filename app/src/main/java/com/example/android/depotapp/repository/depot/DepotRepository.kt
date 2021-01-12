package com.example.android.depotapp.repository.depot

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.parseToDatabaseModel
import kotlinx.coroutines.*

class DepotRepository(private val dao: DepotDao) {

    val allDepots: LiveData<List<Depot>> = Transformations.map(dao.getAllDepots()) {
        it.parseToDomainModel()
    }

    suspend fun addDepot(depots: Depot) {
        withContext(Dispatchers.IO) {

            val depotsToAdd = mutableListOf<Depot>()
            depotsToAdd.add(depots)

            dao.addDepot(depotsToAdd.parseToDatabaseModel())
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