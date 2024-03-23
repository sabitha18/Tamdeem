package com.voxel.tamdeem.ui.world.listing

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityMainBinding
import com.voxel.tamdeem.databinding.ActivityWorldListingBinding
import com.voxel.tamdeem.ui.world.listing.adapter.WorldDetailsListingAdapter
import com.voxel.tamdeem.ui.world.listing.adapter.WorldListingAdapter

class WorldListingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorldListingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityWorldListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageCat()
        manageCatDetails()
    }

    private fun manageCatDetails() {
        binding.recyclerWorldCatList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val catAdapter = WorldDetailsListingAdapter(this@WorldListingActivity,createArtistList()) { Cat, position ->

            }
            adapter = catAdapter
        }
    }

    private fun manageCat() {
        binding.recyclerWorldCat.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val catAdapter = WorldListingAdapter(this@WorldListingActivity,createArtistList()) { Cat, position ->

            }
            adapter = catAdapter
        }
    }
    private fun createArtistList(): ArrayList<Cat> {
        return arrayListOf<Cat>(
            Cat(
                "Thrillies"
            ),
            Cat(
                "Kiddies"
            ),
            Cat(
                "VR/AR"
            )
        )
    }
}