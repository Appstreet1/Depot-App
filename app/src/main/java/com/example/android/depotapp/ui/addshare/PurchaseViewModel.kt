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

    val shareIsValid: LiveData<Boolean>
        get() = _shareIsValid

    private val _share = MutableLiveData<Share>()
    private val _selectedDepot = MutableLiveData<Depot>()
    private var _title = MutableLiveData<String>()
    private var _shareIsValid = MutableLiveData<Boolean>()
    private var depotId: Long = 0


    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
        depotId = _selectedDepot.value!!.id
    }

    fun requestShareBySymbolAndDate(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (shareRepo.requestShareBySymbolAndDate(symbol, date)) {
                is NetworkResult.Success -> {
                    val share = shareRepo.getShareBySymbolAndDate(symbol, date)
                    addShareToPurchase(share)
                    requestTitleBySymbol(symbol)
                }
                is NetworkResult.Error -> _shareIsValid.postValue(false)
            }
        }
    }

    private fun requestTitleBySymbol(symbol: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val title = shareRepo.getTitleBySymbol(symbol)

                _title.postValue(title)

                _shareIsValid.postValue(true)

            } catch (e: Exception) {
                _shareIsValid.postValue(false)
                Log.i("TEST", e.toString())
            }
        }
    }

    fun addPurchase(amount: Double, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val purchase = Purchase(
                    0, _title.value.toString(), amount, 0.0,
                    date, 0.0, depotId
                )

                purchaseRepo.addPurchase(purchase)

            } catch (e: Exception) {

                Log.i("TEST", e.toString())
            }
        }
    }

    private fun addShareToPurchase(share: Share) {
        viewModelScope.launch(Dispatchers.IO) {

            Log.i(
                "TEST",
                "symbol: " + share.symbol + " date " + share.date +
                        " price: " + share.price + "purchaseId: " + share.purchaseId + " title " + share.title
            )
        }
    }
}






















