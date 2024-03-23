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
import com.voxel.tamdeem.databinding.WorldListingDetailsItemBinding
import com.voxel.tamdeem.ui.world.WorldActivity
import com.voxel.tamdeem.ui.world.details.WorldDetailsActivity
import com.voxel.tamdeem.ui.world.listing.WorldListingActivity

class WorldDetailsListingAdapter(
    private val context: Context,
    private val CatList: ArrayList<Cat>,
    private val listener: (Cat, Int) -> Unit
) :
    RecyclerView.Adapter<WorldDetailsListingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = WorldListingDetailsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(CatList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, WorldDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return CatList.size
    }

    class ViewHolder(var itemBinding: WorldListingDetailsItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(cat: Cat) {


        }

    }
}