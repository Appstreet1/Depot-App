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
import java.util.*

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
    private var depotId: Long = 0


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
        depotId = _selectedDepot.value!!.id
    }


    fun addPurchase(title: String, amount: Double, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val purchase = Purchase(
                    0, title, amount, 0.0,
                    date, 0.0, depotId
                )

                purchaseRepo.addPurchase(purchase)
                _purchaseAdded.postValue(true)
            } catch (e: Exception) {

                _purchaseAdded.postValue(false)
                Log.i("TEST", e.toString())
            }
        }
    }

    private fun requestTitleBySymbol(symbolInput: String) {

        val symbol = symbolInput.toUpperCase(Locale.ROOT)

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val title = shareRepo.getTitleBySymbol(symbol)
                _title.postValue(title)

            } catch (e: Exception) {

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
                is NetworkResult.Success -> {
                    requestTitleBySymbol(symbol)
                }
                is NetworkResult.Error -> _networkSuccess.postValue(false)
            }
        }
    }
}