package com.example.android.depotapp.repository.purchases

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.depotapp.database.dao.PurchaseDao
import com.example.android.depotapp.database.entities.PurchaseDatabaseItem
import com.example.android.depotapp.database.entities.parseToDatabaseModel
import com.example.android.depotapp.database.entities.parseToDomainModel
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.model.Share
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PurchaseRepository(private val dao: PurchaseDao) {

    val purchases = dao.getPurchases()


    suspend fun getPurchases() {
        dao.getPurchases()
    }

    suspend fun getPurchasesByDepotId(depotId: Long): List<Purchase> {
        return dao.getPurchasesByDepotId(depotId)
    }

    suspend fun addPurchase(purchase: Purchase) {

        withContext(Dispatchers.IO) {
            dao.addPurchase(purchase.parseToDatabaseModel())
        }
    }

    suspend fun deletePurchase(purchase: PurchaseDatabaseItem) {
        dao.deletePurchase(purchase)
    }

    suspend fun deleteAllPurchases() {
        dao.deleteAllPurchases()
    }
}