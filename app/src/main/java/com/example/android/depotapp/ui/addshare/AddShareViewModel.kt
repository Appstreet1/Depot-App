package com.example.android.depotapp.ui.addshare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddShareViewModel(private val shareRepo: ShareRepository) : ViewModel() {

    val shareAdded: LiveData<Boolean>
        get() = _shareAdded

    val share: LiveData<Share>
        get() = _share

    private val _selectedDepot = MutableLiveData<Depot>()
    private val _share = MutableLiveData<Share>()
    private val _shareAdded = MutableLiveData<Boolean>()

    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    fun requestShare(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (shareRepo.requestShareBySymbolAndDate(symbol, date)) {

                is NetworkResult.Success -> {
                    val share = shareRepo.getShareBySymbolAndDate(symbol,date)
                    addShare(share)
                    _shareAdded.postValue(true)
                }
                is NetworkResult.Error -> _shareAdded.postValue(false)
            }
        }
    }

    private fun addShare(share: Share) {
        viewModelScope.launch(Dispatchers.IO) {
            share.depotId = _selectedDepot.value!!.id

            shareRepo.addShare(share)
        }
    }
}