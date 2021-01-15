package com.example.android.depotapp.ui.selectdepot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import com.example.android.depotapp.ui.depotoverview.DepotOverviewActivity
import kotlinx.android.synthetic.main.depot_list_item.view.*

class DepotListAdapter(private val depots: ArrayList<Depot> = ArrayList()
) : RecyclerView.Adapter<DepotListAdapter.DepotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepotViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.depot_list_item, parent, false)
        return DepotViewHolder(view)
    }

    override fun getItemCount(): Int {
        return depots.size
    }

    override fun onBindViewHolder(holder: DepotViewHolder, position: Int) {
        holder.update(depots[position])
    }

    class DepotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(depot: Depot) = with(itemView) {

            depot_list_item_title.text = depot.title
            depot_list_item_layout.setOnClickListener { DepotOverviewActivity.start(itemView.context, depot) }
        }
    }

    //TODO:implement Diffutilcallback
    fun setData(list: List<Depot>){
            depots.clear()
            depots.addAll(list)
            notifyDataSetChanged()
    }
}