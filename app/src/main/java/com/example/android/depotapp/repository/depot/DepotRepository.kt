package com.example.android.depotapp.repository.depot

import com.example.android.depotapp.database.dao.DepotDao
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch

class DepotRepository(private val dao : DepotDao) {

//    val depots = dao.getDepots()

    //TODO: add Error Handling Callback
    suspend fun getDepots(){
        CoroutineScope(Dispatchers.IO).launch {
            dao.getDepots()
        }
    }

    suspend fun addDepot(depot: DepotDatabaseItem){
        CoroutineScope(Dispatchers.IO).launch {
            dao.addDepot(depot)
        }
    }

    suspend fun updateDepot(depot: DepotDatabaseItem){
        dao.updateDepot(depot)
    }

    suspend fun deleteDepot(depot: DepotDatabaseItem){
        dao.deleteDepot(depot)
    }

    suspend fun deleteAllDepots(){
        dao.deleteAllDepots()
    }
}