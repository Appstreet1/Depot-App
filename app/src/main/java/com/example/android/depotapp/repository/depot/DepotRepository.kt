package com.example.android.depot.repository.depot

import com.example.android.depot.db.depot.DepotDao
import com.example.android.depot.db.depot.DepotDatabaseItem

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