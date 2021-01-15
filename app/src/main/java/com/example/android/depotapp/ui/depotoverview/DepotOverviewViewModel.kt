package com.example.android.depotapp.ui.depotoverview

import androidx.lifecycle.*
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.share.ShareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository,
    private val depotRepo: DepotRepository
) : ViewModel() {

    fun getShares() = shareRepo.shares

    val selectedDepot: LiveData<Depot>
        get() = _selectedDepot

    private val _selectedDepot = MutableLiveData<Depot>()


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    fun requestShare(symbol:String, date: String){

        viewModelScope.launch(Dispatchers.IO) {
            shareRepo.requestShareBySymbolAndDate(symbol, date)
        }

    }
}