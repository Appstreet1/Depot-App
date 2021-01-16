package com.example.android.depotapp.ui.addshare

import android.app.Application
import androidx.lifecycle.*
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.share.ShareRepository
import com.example.android.depotapp.utils.NetworkResult
import com.example.android.depotapp.utils.sendNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AddShareViewModel(private val shareRepo: ShareRepository, private val app: Application) :
    AndroidViewModel(app) {

    val shareAdded: LiveData<Boolean>
        get() = _shareAdded

    val share: LiveData<Share>
        get() = _share

    private val _selectedDepot = MutableLiveData<Depot>()
    private val _share = MutableLiveData<Share>()
    private val _shareAdded = MutableLiveData<Boolean>()

    fun setSelectedDepot(depot: Depot?) {
        if (depot != null) {
            _selectedDepot.value = depot
        }
    }

    fun requestShare(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (shareRepo.requestShare(symbol, date)) {

                is NetworkResult.Success -> addShare(symbol, date)
                is NetworkResult.Error -> _shareAdded.postValue(false)
            }
        }
    }

    private fun addShare(symbol: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val depotId = _selectedDepot.value!!.id
                shareRepo.addShare(symbol, date, depotId)
                _shareAdded.postValue(true)

                sendNotification()
            } catch (e: Exception) {
                _shareAdded.postValue(false)
            }
        }
    }

    fun sendNotification() {
        sendNotification(app.applicationContext, _share.value!!)
    }
}