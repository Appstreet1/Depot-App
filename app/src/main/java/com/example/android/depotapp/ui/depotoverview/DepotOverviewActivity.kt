package com.example.android.depotapp.ui.depotoverview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.addshare.PurchaseActivity
import kotlinx.android.synthetic.main.activity_depot_overview.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

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

    private val viewModel by viewModel<DepotOverviewViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depot_overview)

        getSelectedDepotFromIntent()
        initOnClick()
        observePurchases()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPurchasesByDepotId()
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }

    private fun initOnClick(){
        overview_add_share.setOnClickListener {
            PurchaseActivity.start(this, viewModel.selectedDepot.value!!)
        }
    }

    private fun observePurchases() {
        viewModel.purchases.observe(this, { purchases ->
            try {
                for (i in purchases){
                    Log.i("TEST", i.titleOfShare + " depotId: " + i.depotId + " purchaseId: " + i.purchaseId + " amount: " + i.amountOfShares + " date: " + i.dateOfPurchase)
                }
            }catch (e:Exception){
                Log.i("TEST", "no purchases brother")
            }
        })
    }
}








