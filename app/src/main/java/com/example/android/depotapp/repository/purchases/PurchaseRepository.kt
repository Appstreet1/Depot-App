package com.example.android.depotapp.repository.purchases

import com.example.android.depotapp.database.dao.PurchaseDao
import com.example.android.depotapp.database.entities.PurchaseDatabaseItem


class PurchaseRepository(private val dao : PurchaseDao) {

    val purchases = dao.getPurchases()

    suspend fun getPurchases(){
        dao.getPurchases()
    }

    suspend fun addPurchase(purchase: PurchaseDatabaseItem){
        dao.addPurchase(purchase)
    }

    suspend fun deletePurchase(purchase: PurchaseDatabaseItem){
        dao.deletePurchase(purchase)
    }

    suspend fun deleteAllPurchases(){
        dao.deleteAllPurchases()
    }
}