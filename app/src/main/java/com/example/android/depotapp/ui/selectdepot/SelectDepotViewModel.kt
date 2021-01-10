package com.example.android.depotapp.ui.selectdepot

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.depotapp.database.depot.DepotDatabaseItem
import com.example.android.depotapp.model.Purchase
import com.example.android.depotapp.repository.depot.DepotRepository
import kotlinx.coroutines.launch

class SelectDepotViewModel(private val repository: DepotRepository) : ViewModel() {

    init {
        test_addDepot()
        test_getDepots()
    }

     fun test_addDepot(){

        val list = mutableListOf<Purchase>()
        val purchase = Purchase(52, "titleShare", 2.0,1.0, null, 0.0, null)
        list.add(purchase)
        val depot = DepotDatabaseItem("testOne", list, 2.0, 10.0)

        viewModelScope.launch {
            repository.addDepot(depot)
            Log.i("TEST", "add")
        }
    }

     fun test_getDepots(){

        viewModelScope.launch {
           val list = repository.getDepots()
            Log.i("TEST", list.toString())
        }
    }

}