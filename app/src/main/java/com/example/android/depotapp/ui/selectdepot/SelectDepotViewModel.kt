package com.example.android.depotapp.ui.selectdepot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.repository.depot.DepotRepository
import kotlinx.coroutines.launch

class SelectDepotViewModel(private val repository: DepotRepository) : ViewModel() {

    val depots: LiveData<List<DepotDatabaseItem>>
        get() = _depots

    private val _depots = MutableLiveData<List<DepotDatabaseItem>>()

}