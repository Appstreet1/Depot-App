package com.example.android.depotapp.ui.depotoverview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.depot.DepotRepository
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository,
    private val depotRepo: DepotRepository
) : ViewModel() {

    fun getShares() = shareRepo.shares

    val share: LiveData<Share>
        get() = _share

    val selectedDepot: LiveData<Depot>
        get() = _selectedDepot

    private val _share = MutableLiveData<Share>()
    private val _selectedDepot = MutableLiveData<Depot>()

    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
        Log.i("TEST", _selectedDepot.value.toString())
    }

    fun getDepotById(){
        TODO()
    }

    fun deleteDepot(depot: Depot?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (depot != null) {
                depotRepo.deleteDepot(depot)
            }
        }
    }


    fun requestShareBySymbolAndDate(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (shareRepo.requestShareBySymbolAndDate(symbol, date)) {
                is NetworkResult.Success -> _share.postValue(
                    shareRepo.getShareBySymbolAndDate(
                        symbol,
                        date
                    )
                )
                is NetworkResult.Error -> Log.i("TEST", "FAIL")
            }
        }
    }

    fun getTitleBySymbol(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val title = shareRepo.getTitleBySymbol(symbol)

            Log.i("TEST", title.toString() + "f")
        }
    }
}