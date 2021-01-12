package com.example.android.depotapp.ui.adddepot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.depotoverview.DepotOverviewActivity
import com.example.android.depotapp.ui.selectdepot.SelectDepotActivity
import com.example.android.depotapp.ui.selectdepot.SelectDepotViewModel
import kotlinx.android.synthetic.main.activity_add_depot.*
import org.koin.android.viewmodel.ext.android.viewModel

class AddDepotActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddDepotActivity::class.java)

            context.startActivity(intent)
        }
    }


    private val addDepotViewModel by viewModel<AddDepotViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_depot)

        initOnClick()
    }

    private fun initOnClick() {

        depot_save_button.setOnClickListener {
            addDepot()
            SelectDepotActivity.start(this)
            finish()
        }
    }

    private fun addDepot() {
        val depotTitle = depot_name_input.text.toString()
        val depot = Depot(0, depotTitle, 0.0, 0.0)

        addDepotViewModel.insertDepot(depot)
    }
}