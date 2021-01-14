package com.example.android.depotapp.ui.addshare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import kotlinx.android.synthetic.main.activity_add_share.*
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
        setContentView(R.layout.activity_add_share)

        getSelectedDepotFromIntent()
        initOnClick()

    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
            Log.i("TEST", depot.toString())
        }
    }


    //TODO: Add purchase with date, amount, price, shares etc..
    private fun initOnClick() {
        add_share_btn.setOnClickListener {
            val userInput = add_share_symbol_et.text.toString()
            val symbol = userInput.toUpperCase(Locale.ROOT)


            viewModel.getTitleBySymbol(symbol)

            viewModel.title.observe(this, { title ->
                if (title != null) {
                    viewModel.addPurchase(title)
                }else{
                    Log.i("TEST", "add share error")
                }
            })
        }
    }
}