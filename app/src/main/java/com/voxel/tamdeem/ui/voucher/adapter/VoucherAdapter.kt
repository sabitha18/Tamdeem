package com.voxel.tamdeem.ui.voucher.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.databinding.HomeHistoryItemBinding
import com.voxel.tamdeem.databinding.VoucherItemBinding
import com.voxel.tamdeem.ui.voucher.VoucherDetailsActivity
import com.voxel.tamdeem.ui.world.listing.WorldListingActivity

class VoucherAdapter(
    private val context: Context,
    private val CatList: ArrayList<Cat>,
    private val listener: (Cat, Int) -> Unit
) :
    RecyclerView.Adapter<VoucherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = VoucherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(CatList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(context, VoucherDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return CatList.size
    }

    class ViewHolder(var itemBinding: VoucherItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(cat: Cat) {

        }
    }
}