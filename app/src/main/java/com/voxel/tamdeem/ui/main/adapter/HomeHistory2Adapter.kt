package com.voxel.tamdeem.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.databinding.HomeHistoryItemBinding

class HomeHistory2Adapter(
    private val context: Context,
    private val CatList: ArrayList<Cat>,
    private val listener: (Cat, Int) -> Unit
) :
    RecyclerView.Adapter<HomeHistory2Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = HomeHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(CatList[position])
        holder.itemView.setOnClickListener { listener(CatList[position], position)
        }
    }



    override fun getItemCount(): Int {
        return CatList.size
    }

    class ViewHolder(var itemBinding: HomeHistoryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(cat: Cat) {

        }
    }
}