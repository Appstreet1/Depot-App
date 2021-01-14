package com.example.android.depotapp.ui.addshare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.depotoverview.DepotOverviewActivity
import com.example.android.depotapp.ui.depotoverview.DepotOverviewViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AddShareActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, depot: Depot) {
            val intent = Intent(context, AddShareActivity::class.java)

            depot.run {
                intent.putExtra("depot_arg", depot)
            }
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModel<AddShareViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_share)

        getSelectedDepotFromIntent()
    }

    private fun getSelectedDepotFromIntent() {
        val depot: Depot? = intent.getParcelableExtra("depot_arg")
        if (depot != null) {
            viewModel.setSelectedDepot(depot)
            Log.i("TEST", depot.toString())
        }
    }

//    private fun initOnClick(){
//        addContentView()
//    }
}