package com.voxel.tamdeem.ui.world.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.databinding.HomeHistoryItemBinding
import com.voxel.tamdeem.databinding.WorldItemBinding
import com.voxel.tamdeem.ui.world.WorldActivity
import com.voxel.tamdeem.ui.world.listing.WorldListingActivity

class WorldAdapter(
    private val context: Context,
    private val CatList: ArrayList<Cat>,
    private val listener: (Cat, Int) -> Unit
) :
    RecyclerView.Adapter<WorldAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = WorldItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(CatList[position])
        holder.itemBinding.lytDetails.setOnClickListener {
            val intent = Intent(context, WorldListingActivity::class.java)
            context.startActivity(intent)

        }
    }



    override fun getItemCount(): Int {
        return CatList.size
    }

    class ViewHolder(var itemBinding: WorldItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(cat: Cat) {
            itemBinding.imgWorld.setOnClickListener {
                // Toggle visibility of lyt_details
                itemBinding.lytDetails.visibility = if (itemBinding.lytDetails.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }


        }

    }
}