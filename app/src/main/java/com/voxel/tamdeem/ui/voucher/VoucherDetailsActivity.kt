package com.voxel.tamdeem.ui.voucher

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityVoucherBinding
import com.voxel.tamdeem.databinding.ActivityVoucherDetailsBinding
import com.voxel.tamdeem.ui.login.LoginActivity

class VoucherDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVoucherDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityVoucherDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleClick()
    }
    private fun handleClick() {
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@VoucherDetailsActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

    }
}