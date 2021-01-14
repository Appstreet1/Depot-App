package com.example.android.depotapp.ui.depotoverview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import org.koin.android.viewmodel.ext.android.viewModel

class DepotOverviewActivity : AppCompatActivity() {

    //TODO: add share to particular purchase, depot
    //TODO: fetch data from current daepot
    //TODO: delete depot

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, DepotOverviewActivity::class.java)

            depot.run {
                intent.putExtra("depot_arg", depot)
            }
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModel<DepotOverviewViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depot_overview)

        getSelectedDepotFromIntent()
        observeShares()
//        viewModel.requestShareBySymbolAndDate("AAPL", "2021-01-12")
        observeRequestedShare()

    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        Log.i("TEST", depot.toString() + " act")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }

    private fun observeRequestedShare() {
        viewModel.share.observe(this, { share ->
            viewModel.getTitleBySymbol(share.symbol.toString())
        })
    }

    private fun observeShares() {
        viewModel.getShares().observe(this, { shares ->
            if (shares.isNotEmpty()) {
                Log.i("TEST", shares[0].toString())
            } else {
                Log.i("TEST", "leer")
            }
        })
    }
}