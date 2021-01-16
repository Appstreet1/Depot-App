package com.example.android.depotapp.ui.detailShare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.ui.depotoverview.DepotOverviewViewModel
import kotlinx.android.synthetic.main.activity_share_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class ShareDetailActivity : AppCompatActivity() {

    private val viewModel by viewModel<ShareDetailViewModel>()


    companion object {
        fun start(context: Context, share: Share) {
            val intent = Intent(context, ShareDetailActivity::class.java)

            share.run {
                intent.putExtra(context.getString(R.string.share_arg), share)
            }
            context.startActivity(intent)
        }

        private const val EXTRA_ReminderDataItem = "EXTRA_ReminderDataItem"
        //        receive the reminder object after the user clicks on the notification
        fun newIntent(context: Context, share: Share): Intent {

            val intent = Intent(context, ShareDetailActivity::class.java)
            intent.putExtra(EXTRA_ReminderDataItem, share)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_detail)

        getShareFromIntent()
        renderUI()
    }


    private fun getShareFromIntent() {
        val share: Share? = intent.getParcelableExtra(this.getString(R.string.share_arg))

        if (share != null) {
            viewModel.setShare(share)
        }
    }

    private fun renderUI() {
        viewModel.selectedShare.observe(this, { share ->
            detail_country.text = share.country
            detail_description.text = share.description
            detail_industry.text = share.industry
            detail_sector.text = share.sector
        })
    }
}