package com.example.android.depotapp.ui.depotoverview

import androidx.lifecycle.*
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.share.ShareRepository

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository,
    private val depotRepo: DepotRepository
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
}