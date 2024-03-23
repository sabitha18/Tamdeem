package com.voxel.tamdeem.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voxel.tamdeem.R

class SliderAdapter(private val itemCount: Int) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    private var selectedPosition = 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind your views for each item here

        // Update dot indicator
//        holder.itemView.findViewById<View>(R.id.dotContainer).background =
//            if (position == selectedPosition)
//                holder.itemView.context.getDrawable(R.drawable.active_icon)
//            else
//                holder.itemView.context.getDrawable(R.drawable.inactive_icon)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }
}
