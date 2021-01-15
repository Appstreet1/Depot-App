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

class PurchaseViewModel(
    private val shareRepo: ShareRepository,
    private val purchaseRepo: PurchaseRepository
) : ViewModel() {

    val share: LiveData<Share>
        get() = _share

    val title: LiveData<String>
        get() = _title

    val purchaseAdded: LiveData<Boolean>
        get() = _purchaseAdded

    val networkSuccess: LiveData<Boolean>
        get() = _networkSuccess


    private val _share = MutableLiveData<Share>()
    private val _selectedDepot = MutableLiveData<Depot>()
    private var _title = MutableLiveData<String>()
    private var _purchaseAdded = MutableLiveData<Boolean>()
    private var _networkSuccess = MutableLiveData<Boolean>()

    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    fun addPurchase(title: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val purchase = Purchase(
                    0, title, 1.0, 0.0,
                    "2012", 0.0, _selectedDepot.value!!.id
                )

                purchaseRepo.addPurchase(purchase)
                _purchaseAdded.postValue(true)
            } catch (e: Exception) {

                _purchaseAdded.postValue(false)
                Log.i("TEST", e.toString())
            }
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

            try {
                val title = shareRepo.getTitleBySymbol(symbol)
                _title.postValue(title)
                _networkSuccess.postValue(true)
            } catch (e: Exception) {
                _networkSuccess.postValue(false)
                Log.i("TEST", e.toString())
            }
        }
    }
}