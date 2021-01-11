package com.example.android.depotapp.ui.selectdepot

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.depotapp.R
import com.example.android.depotapp.model.Depot
import kotlinx.android.synthetic.main.depot_list_item.view.*

class DepotListAdapter(private val depots: ArrayList<Depot> = ArrayList()
) : RecyclerView.Adapter<DepotListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.depot_list_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return depots.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.update(depots[position])
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(depot: Depot) = with(itemView) {

            depot_list_item_title.text = depot.title

            depot_list_item_layout.setOnClickListener { Log.i("TEST", "click") }
        }
    }

    //TODO:implement Diffutilcallback
    fun setData(list: List<Depot>){
        depots.clear()
        depots.addAll(list)
        notifyDataSetChanged()
    }
}