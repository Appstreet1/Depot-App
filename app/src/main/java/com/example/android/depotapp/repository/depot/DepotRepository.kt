package com.example.android.depotapp.repository.depot

import com.example.android.depotapp.database.depot.DepotDao
import com.example.android.depotapp.database.depot.DepotDatabaseItem

class DepotRepository(private val dao : DepotDao) {

    val depots = dao.getDepots()

    suspend fun getDepots(){
        dao.getDepots()
    }

    suspend fun addDepot(depot: DepotDatabaseItem){
        dao.addDepot(depot)
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