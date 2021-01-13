package com.example.android.depotapp.ui.depotoverview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(private val repository: ShareRepository) : ViewModel() {

    fun getShares() = repository.shares

    val share: LiveData<Share>
        get() = _share

    private val _share = MutableLiveData<Share>()


    fun requestShareBySymbolAndDate(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (repository.requestShareBySymbolAndDate(symbol, date)) {
                is NetworkResult.Success -> _share.postValue(repository.getShareBySymbolAndDate(symbol, date))
                is NetworkResult.Error -> Log.i("TEST", "FAIL")
            }
        }
    }

    fun getTitleBySymbol(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val title = repository.getTitleBySymbol(symbol)

            Log.i("TEST", title.toString() + "f")
        }
    }
}