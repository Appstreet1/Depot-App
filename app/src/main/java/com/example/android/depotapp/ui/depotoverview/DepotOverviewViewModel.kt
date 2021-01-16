package com.example.android.depotapp.ui.depotoverview

import androidx.lifecycle.*
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.repository.share.ShareRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DepotOverviewViewModel(
    private val shareRepo: ShareRepository
) : ViewModel(), DefaultLifecycleObserver {


    val selectedDepot: LiveData<Depot>
        get() = _selectedDepot

    val shares: LiveData<List<Share>>
        get() = _shares

    private val _selectedDepot = MutableLiveData<Depot>()
    private val _shares = MutableLiveData<List<Share>>()


    init {
        getSharesOfDepot()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getSharesOfDepot()
    }

    fun setSelectedDepot(depot: Depot) {
        _selectedDepot.value = depot
    }

    private fun getSharesOfDepot() {

        viewModelScope.launch(Dispatchers.IO) {

            val shares = _selectedDepot.value?.id?.let { shareRepo.getShares(it) }
            _shares.postValue(shares)
        }
    }
}