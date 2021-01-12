package com.example.android.depotapp.ui.adddepot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.repository.depot.DepotRepository
import kotlinx.coroutines.launch

class AddDepotViewModel(private val repository: DepotRepository) : ViewModel() {


    fun insertDepot(depot: Depot) {

        viewModelScope.launch { repository.addDepot(depot) }
    }

}