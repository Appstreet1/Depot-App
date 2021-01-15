package com.example.android.depotapp.ui.selectdepot

import androidx.lifecycle.ViewModel
import com.example.android.depotapp.repository.depot.DepotRepository

class SelectDepotViewModel(private val repository: DepotRepository) : ViewModel() {

    fun getDepots() = repository.allDepots
}