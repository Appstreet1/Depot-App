package com.example.android.depotapp.ui.addshare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.ui.depotoverview.DepotOverviewActivity
import com.example.android.depotapp.ui.depotoverview.DepotOverviewViewModel
import com.example.android.depotapp.utils.NetworkResult
import kotlinx.android.synthetic.main.activity_add_share.*
import kotlinx.android.synthetic.main.activity_depot_overview.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class AddShareActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, AddShareActivity::class.java)

            depot.run {
                intent.putExtra(context.getString(R.string.depot_arg), depot)
            }
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModel<AddShareViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_share)

        getSelectedDepotFromIntent()
        initOnClick()
        observeStatus()
    }


    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra(this.getString(R.string.depot_arg))
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
        }
    }

    private fun initOnClick() {
        add_sh_add_btn.setOnClickListener {

            val symbol = addsh_symbol_et.text.toString().toUpperCase(Locale.ROOT)
            val date = add_sh_date.text.toString()

            viewModel.requestShare(symbol, date)
        }
    }

    private fun observeStatus() {
        viewModel.shareAdded.observe(this, { shareAdded ->
            if (shareAdded) {
                finish()
            } else {
                Toast.makeText(this, getString(R.string.someth_went_wrong), Toast.LENGTH_SHORT).show()
            }
        })
    }
}