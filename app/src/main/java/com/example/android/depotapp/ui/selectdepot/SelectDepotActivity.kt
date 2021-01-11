package com.example.android.depotapp.ui.selectdepot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.depotapp.R
import com.example.android.depotapp.database.DepotDatabase
import org.koin.android.viewmodel.ext.android.viewModel

class SelectDepotActivity : AppCompatActivity() {

    private val selectDepotViewModel by viewModel<SelectDepotViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_depot)

      DepotDatabase.getDatabase(this)
//
//        db.depotDao.getDepots()

//        selectDepotViewModel.test_addDepot()
    }
}