package com.example.android.depotapp.ui.depotoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Share
import com.example.android.depotapp.ui.detailShare.ShareDetailActivity
import kotlinx.android.synthetic.main.share_list_item.view.*

class ShareListAdapter(
    private val shares: ArrayList<Share> = ArrayList()
) : RecyclerView.Adapter<ShareListAdapter.PurchaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.share_list_item, parent, false)
        return PurchaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shares.size
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.update(shares[position])
    }

    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(share: Share) = with(itemView) {

            list_share_date.text = share.date
            list_share_symbol.text = share.symbol

            share_list_item.setOnClickListener { ShareDetailActivity.start(itemView.context, share) }
        }
    }

    fun setData(list: List<Share>) {
        shares.clear()
        shares.addAll(list)
        notifyDataSetChanged()
    }
}
