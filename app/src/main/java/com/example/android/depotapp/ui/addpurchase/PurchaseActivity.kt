package com.example.android.depotapp.ui.addpurchase

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
import java.util.*

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
        observeStatus()
        observeShares()
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }

    private fun initOnClick() {
        purchase_add_btn.setOnClickListener {
            val symbol = purchase_symbol_et.text.toString().toUpperCase(Locale.ROOT)
            val date = purchase_date.text.toString()

            viewModel.requestShareBySymbolAndDate(symbol, date)
        }
    }

    private fun observeStatus() {
        viewModel.shareIsValid.observe(this, { shareIsValid ->
            if (shareIsValid) {

                val amount = purchase_amount.text.toString().toDouble()
                val date = purchase_date.text.toString()

                viewModel.addPurchase(amount, date)

                finish()

            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun observeShares() {
        viewModel.allShares.observe(this, { shares ->
            try {
                for (share in shares){
                    Log.i("TEST", "shares: " + "id: " + share.id + " price: "
                     + share.price + " purchaseId: " + share.purchaseId+ " symbol: " + share.symbol + " " + share.date)
                }

            } catch (e: Exception) {
                Log.i("TEST", e.toString())
            }
        })
    }
}





















