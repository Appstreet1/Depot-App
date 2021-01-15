package com.example.android.depotapp.ui.depotoverview

import android.util.Log
import androidx.lifecycle.*
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository
) : ViewModel() {

    fun getShares() = shareRepo.shares

    val selectedDepot: LiveData<Depot>
        get() = _selectedDepot

    private val _selectedDepot = MutableLiveData<Depot>()
    private val _share = MutableLiveData<Share>()


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }


}