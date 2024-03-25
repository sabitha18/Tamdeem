package com.voxel.tamdeem.ui.account

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityAccountBinding
import com.voxel.tamdeem.databinding.ActivityBonusBinding
import com.voxel.tamdeem.ui.main.adapter.HomeHistoryAdapter

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageHistory()
    }
    private fun manageHistory() {
        binding.recyclerHistory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val historyAdapter = HomeHistoryAdapter(this@AccountActivity, createArtistList()) { Cat, position ->

            }
            adapter = historyAdapter
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