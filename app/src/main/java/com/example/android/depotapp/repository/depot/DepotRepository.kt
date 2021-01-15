package com.example.android.depotapp.repository.depot

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.parseToDatabasemodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DepotRepository(private val dao: DepotDao) {

    val allDepots: LiveData<List<Depot>> = Transformations.map(dao.getAllDepots()) {
        it.parseToDomainModel()
    }

    suspend fun addDepot(depot: Depot) {
        withContext(Dispatchers.IO) {
            dao.addDepot(depot.parseToDatabasemodel())
        }
    }
}