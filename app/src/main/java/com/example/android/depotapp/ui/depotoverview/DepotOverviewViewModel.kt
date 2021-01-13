package com.example.android.depotapp.ui.depotoverview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.repository.share.ShareRepository
import kotlinx.coroutines.launch

class DepotOverviewViewModel(private val repository: ShareRepository) : ViewModel() {

    fun getShares() = repository.shares


    fun addShareBySymbolAndDate(){
        viewModelScope.launch {
            repository.addShareBySymbol("AAPL", "2021-01-12")
        }
    }
}