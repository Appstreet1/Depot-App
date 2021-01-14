package com.example.android.depotapp.ui.depotoverview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import org.koin.android.viewmodel.ext.android.viewModel

class DepotOverviewActivity : AppCompatActivity() {

    //TODO: fetch data(purchases, shares..) from current depot
    //TODO: add share to particular purchase, depot

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
        observeRequestedShare()
        observePurchases()

        val purchase = Purchase(
            0, "title", 1.0, 200.0, "2020-10-21", 1.0,
            viewModel.selectedDepot.value!!.id)

        viewModel.addPurchase(purchase)
        viewModel.getPurchasesByDepotId()
    }


    private fun observePurchases() {
        viewModel.purchases.observe(this, { purchases ->
            Log.i("TEST", purchases[1].purchaseId.toString())
        })
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
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
//                Log.i("TEST", "shares available")
            } else {
//                Log.i("TEST", "leer")
            }
        })
    }
}