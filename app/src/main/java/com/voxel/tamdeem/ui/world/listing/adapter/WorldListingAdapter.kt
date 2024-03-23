package com.voxel.tamdeem.ui.world.listing.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.databinding.HomeHistoryItemBinding
import com.voxel.tamdeem.databinding.WorldItemBinding
import com.voxel.tamdeem.databinding.WorldListingItemBinding
import com.voxel.tamdeem.ui.world.WorldActivity
import com.voxel.tamdeem.ui.world.listing.WorldListingActivity

class WorldListingAdapter(
    private val context: Context,
    private val CatList: ArrayList<Cat>,
    private val listener: (Cat, Int) -> Unit
) :
    RecyclerView.Adapter<WorldListingAdapter.ViewHolder>() {
    private var selectedItemPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = WorldListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(CatList[position], position == selectedItemPosition)
        holder.itemView.setOnClickListener {
            if (selectedItemPosition != position) {
                val previousSelectedPosition = selectedItemPosition
                selectedItemPosition = position
                notifyItemChanged(previousSelectedPosition)
                notifyItemChanged(selectedItemPosition)
            }
        }
    }


    override fun getItemCount(): Int {
        return CatList.size
    }

    inner class ViewHolder(private val itemBinding: WorldListingItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindItem(cat: Cat, isSelected: Boolean) {
            with(itemBinding) {
                textName.text = cat.name
                cardSelection.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE
            }
        }
    }
}