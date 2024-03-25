package com.voxel.tamdeem.ui.event.details

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityEventBinding
import com.voxel.tamdeem.databinding.ActivityEventDetailsBinding
import com.voxel.tamdeem.ui.event.add.AddEventActivity
import com.voxel.tamdeem.ui.login.LoginActivity

class EventDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityEventDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }
    private fun handleClick() {
        binding.cardAdd.setOnClickListener {
            val intent = Intent(this@EventDetailsActivity, AddEventActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@EventDetailsActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}