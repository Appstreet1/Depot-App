package com.example.android.depotapp.repository.purchases

import com.example.android.depotapp.database.dao.PurchaseDao
import com.example.android.depotapp.database.entities.PurchaseDatabaseItem
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Purchase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PurchaseRepository(private val dao: PurchaseDao) {

    val purchases = dao.getPurchases()

    suspend fun getPurchasesByDepotId(depotId: Long): List<Purchase> {
        return dao.getPurchasesByDepotId(depotId)
    }

    suspend fun addPurchase(purchase: PurchaseDatabaseItem) {

        withContext(Dispatchers.IO) {
            dao.addPurchase(purchase)
        }
    }

    suspend fun getLastPurchase(): Purchase {
        return dao.getLastInsertedPurchase().parseToDomainModel()
    }
}