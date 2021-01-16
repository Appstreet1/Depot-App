package com.example.android.depotapp.ui.selectdepot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.depotapp.R
import com.example.android.depotapp.ui.adddepot.AddDepotActivity
import kotlinx.android.synthetic.main.activity_select_depot.*
import org.koin.android.viewmodel.ext.android.viewModel

class SelectDepotActivity : AppCompatActivity() {

    private val viewModel by viewModel<SelectDepotViewModel>()
    private lateinit var listAdapter: DepotListAdapter

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SelectDepotActivity::class.java)

            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_depot)

        initOnClick()
        initRecyclerView()
        observeDepots()
    }

    private fun initOnClick() {
        depot_add_button.setOnClickListener {
            AddDepotActivity.start(this)
        }
    }

    private fun initRecyclerView() {
        listAdapter = DepotListAdapter()

        depot_recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun observeDepots() {
        viewModel.getDepots().observe(this, { depots ->
            listAdapter.setData(depots)
        })
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, getString(R.string.please_click_again), Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1500)
    }
}