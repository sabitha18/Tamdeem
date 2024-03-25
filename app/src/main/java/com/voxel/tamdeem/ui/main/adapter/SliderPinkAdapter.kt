package com.voxel.tamdeem.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.voxel.tamdeem.R

class SliderPinkAdapter (private val carouselDataList: ArrayList<String>) :
    RecyclerView.Adapter<SliderPinkAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_pink, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return carouselDataList.size
    }

}