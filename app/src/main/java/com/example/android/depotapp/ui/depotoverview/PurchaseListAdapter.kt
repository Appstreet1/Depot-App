package com.example.android.depotapp.ui.depotoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.model.Purchase
import kotlinx.android.synthetic.main.depot_list_item.view.*
import kotlinx.android.synthetic.main.purchase_list_item.view.*

class PurchaseListAdapter(private val purchases: ArrayList<Purchase> = ArrayList()
) : RecyclerView.Adapter<PurchaseListAdapter.PurchaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.purchase_list_item, parent, false)
        return PurchaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.update(purchases[position])
    }

    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(purchase: Purchase) = with(itemView) {

            list_purchase_title.text = purchase.titleOfShare
            list_purchase_date.text = purchase.dateOfPurchase

        }
    }

    //TODO:implement Diffutilcallback
    fun setData(list: List<Purchase>){
        purchases.clear()
        purchases.addAll(list)
            notifyDataSetChanged()
    }
}