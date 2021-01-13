package com.example.android.depotapp.ui.depotoverview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.adddepot.AddDepotViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DepotOverviewActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, DepotOverviewActivity::class.java)

            depot.run {
                intent.putExtra("depot_arg", depot)
            }
            context.startActivity(intent)
        }
    }

    private val depotOverviewViewModel by viewModel<DepotOverviewViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depot_overview)

        observeShares()
    }

    private fun observeShares(){
        depotOverviewViewModel.getShares().observe(this, { shares ->
            if(shares.isNotEmpty()){
                Log.i("TEST", shares[0].symbol.toString())
            }else{
                Log.i("TEST", "leer")
            }
        })
    }
}