package com.example.android.depotapp.ui.selectdepot

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android.depotapp.R
import com.example.android.depotapp.database.DepotDatabase
import org.koin.android.viewmodel.ext.android.viewModel

class SelectDepotActivity : AppCompatActivity() {

    private val selectDepotViewModel by viewModel<SelectDepotViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_depot)

        //add and retrieve data

        selectDepotViewModel.getDepots().observe(this, Observer { depots->
            if(depots.isNotEmpty()){
                Log.i("TEST", depots.toString())
            }else
            {
                Log.i("TEST", "empty")
            }
        })
    }
}