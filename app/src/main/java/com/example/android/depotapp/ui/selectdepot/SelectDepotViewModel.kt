package com.example.android.depotapp.ui.selectdepot

import android.util.Log
import androidx.lifecycle.*
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.repository.depot.DepotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SelectDepotViewModel(private val repository: DepotRepository) : ViewModel() {

    fun getDepots() = repository.allDepots


}