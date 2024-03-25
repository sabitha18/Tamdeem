package com.voxel.tamdeem.ui.bonus

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityBonusBinding
import com.voxel.tamdeem.databinding.ActivityLoginBinding
import com.voxel.tamdeem.ui.bonus.adapter.BonusAdapter
import com.voxel.tamdeem.ui.login.LoginActivity
import com.voxel.tamdeem.ui.world.listing.adapter.WorldDetailsListingAdapter

class BonusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBonusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityBonusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
        manageListing()
    }

    private fun manageListing() {
        binding.recyclerList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val catAdapter = BonusAdapter(this@BonusActivity,createArtistList()) { Cat, position ->

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
    private fun handleClick() {
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@BonusActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}