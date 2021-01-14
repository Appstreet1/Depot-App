package com.example.android.depotapp.ui.addshare

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.purchases.PurchaseRepository
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddShareViewModel(
    private val shareRepo: ShareRepository,
    private val purchaseRepo: PurchaseRepository
) : ViewModel() {

    val share: LiveData<Share>
        get() = _share

    private val _share = MutableLiveData<Share>()
    private val _selectedDepot = MutableLiveData<Depot>()


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    fun addPurchase(purchase: Purchase) {
        viewModelScope.launch(Dispatchers.IO) {
            purchaseRepo.addPurchase(purchase)
        }
    }

    fun addShareToPurchase() {
        viewModelScope.launch(Dispatchers.IO) {
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

            Log.i("TEST", title.toString())
        }
    }
}