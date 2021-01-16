package com.example.android.depotapp.ui.depotoverview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.addshare.AddShareActivity
import kotlinx.android.synthetic.main.activity_depot_overview.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

class DepotOverviewActivity : AppCompatActivity() {


    private val viewModel by viewModel<DepotOverviewViewModel>()
    private lateinit var listAdapter: ShareListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depot_overview)

        getSelectedDepotFromIntent()
        initOnClick()
        observeShares()
        initRecyclerView()
        lifecycle.addObserver(viewModel)
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra(getString(R.string.depot_arg))
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }

    private fun initOnClick() {
        overview_add_share.setOnClickListener {
            AddShareActivity.start(this, viewModel.selectedDepot.value!!)
        }
    }

    private fun observeShares() {
        viewModel.shares.observe(this, { shares ->
            shares?.let {
                listAdapter.setData(shares)
            }
        })
    }

    private fun initRecyclerView() {
        listAdapter = ShareListAdapter()

        overview_recyclerview.apply {
            layoutManager = LinearLayoutManager(this.context)
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }

    }

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, DepotOverviewActivity::class.java)

            depot.run {
                intent.putExtra(context.getString(R.string.depot_arg), depot)
            }
            context.startActivity(intent)
        }
    }
}








