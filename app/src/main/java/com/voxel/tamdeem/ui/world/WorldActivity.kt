package com.voxel.tamdeem.ui.world

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityMainBinding
import com.voxel.tamdeem.databinding.ActivityWorldBinding
import com.voxel.tamdeem.ui.main.adapter.HomeHistoryAdapter
import com.voxel.tamdeem.ui.world.adapter.WorldAdapter

class WorldActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorldBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageWorld()
    }

    private fun manageWorld() {
        binding.recyclerWorld.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val worldAdapter = WorldAdapter(this@WorldActivity, createArtistList()) { Cat, position ->

            }
            adapter = worldAdapter
        }
    }
    private fun createArtistList(): ArrayList<Cat> {
        return arrayListOf<Cat>(
            Cat(
                "Lily"
            ),
            Cat(
                "Lee"
            ),
            Cat(
                "Jason"
            )
        )
    }
}