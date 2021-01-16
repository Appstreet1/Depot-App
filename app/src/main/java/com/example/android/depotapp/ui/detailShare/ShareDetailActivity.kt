package com.example.android.depotapp.ui.detailShare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.ui.depotoverview.DepotOverviewViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ShareDetailActivity : AppCompatActivity() {

    private val viewModel by viewModel<ShareDetailViewModel>()


    companion object {
        fun start(context: Context, share: Share) {
            val intent = Intent(context, ShareDetailActivity::class.java)

            share.run {
                intent.putExtra("share_arg", share)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_detail)

        getShareFromIntent()
    }


    private fun getShareFromIntent() {
        val share: Share? = intent.getParcelableExtra("share_arg")

        if (share != null) {
            viewModel.setShare(share)
        }
    }
}