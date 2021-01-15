package com.example.android.depotapp.ui.depotoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Share

class ShareListAdapter(
    private val purchases: ArrayList<Share> = ArrayList()
) : RecyclerView.Adapter<ShareListAdapter.PurchaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.share_list_item, parent, false)
        return PurchaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.update(purchases[position])
    }

    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(share: Share) = with(itemView) {


        }
    }

    //TODO:implement Diffutilcallback
    fun setData(list: List<Share>) {
        purchases.clear()
        purchases.addAll(list)
        notifyDataSetChanged()
    }
}