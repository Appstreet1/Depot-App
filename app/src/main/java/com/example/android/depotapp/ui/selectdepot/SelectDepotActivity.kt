package com.example.android.depotapp.ui.selectdepot

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.depotapp.R
import com.example.android.depotapp.database.DepotDatabase
import com.example.android.depotapp.database.entities.DepotDatabaseItem
import kotlinx.android.synthetic.main.activity_select_depot.*
import org.koin.android.viewmodel.ext.android.viewModel

class SelectDepotActivity : AppCompatActivity() {

    private val selectDepotViewModel by viewModel<SelectDepotViewModel>()
    private lateinit var listAdapter: DepotListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_depot)

        initRecyclerView()
        observeDepots()
    }

    private fun initRecyclerView(){
        listAdapter = DepotListAdapter()

        depot_recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun observeDepots() {
        selectDepotViewModel.getDepots().observe(this, Observer { depots ->
            listAdapter.setData(depots)
            Log.i("TEST", depots.toString())
        })
    }
}