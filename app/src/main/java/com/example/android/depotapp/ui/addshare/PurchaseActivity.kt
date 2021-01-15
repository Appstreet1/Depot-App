package com.example.android.depotapp.ui.addshare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import kotlinx.android.synthetic.main.activity_purchase.*
import org.koin.android.viewmodel.ext.android.viewModel

class PurchaseActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, PurchaseActivity::class.java)

            depot.run {
                intent.putExtra("depot_arg", depot)
            }
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModel<PurchaseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        getSelectedDepotFromIntent()
        initOnClick()
        observeShareRequest()
        observePurchaseEntry()
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }


    //TODO: Add purchase with date, amount, price, shares etc..
    private fun initOnClick() {
        purchase_add_btn.setOnClickListener {
            val symbol = purchase_symbol_et.text.toString()
            val date = purchase_date.text.toString()

            viewModel.requestShareBySymbolAndDate(symbol,date)
        }
    }

    private fun observeShareRequest(){
        viewModel.title.observe(this, { title ->
            if (title != null) {

                val amount = purchase_amount.text.toString().toDouble()
                val date = purchase_date.text.toString()

                viewModel.addPurchase(title, amount, date)
            }else{
                Log.i("TEST", "add share error")
            }
        })
    }

    private fun observePurchaseEntry(){
        viewModel.networkSuccess.observe(this, { networkSuccess ->
            if (networkSuccess) {
                finish()
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}






















