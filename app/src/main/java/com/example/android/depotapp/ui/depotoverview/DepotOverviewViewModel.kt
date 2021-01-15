package com.example.android.depotapp.ui.depotoverview

import android.util.Log
import androidx.lifecycle.*
import com.example.android.depotapp.database.entities.DepotWithPurchases
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.purchases.PurchaseRepository
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository,
    private val depotRepo: DepotRepository,
    private val purchaseRepo: PurchaseRepository
) : ViewModel() {

    fun getShares() = shareRepo.shares

    val selectedDepot: LiveData<Depot>
        get() = _selectedDepot

    val purchases: LiveData<List<Purchase>>
        get() = _purchasesOfDepot

    private val _selectedDepot = MutableLiveData<Depot>()
    private val _purchasesOfDepot = MutableLiveData<List<Purchase>>()


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    fun getPurchasesByDepotId() {
        viewModelScope.launch(Dispatchers.IO) {
            _purchasesOfDepot.postValue(purchaseRepo.getPurchasesByDepotId(_selectedDepot.value!!.id))
        }
    }
}