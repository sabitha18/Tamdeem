package com.voxel.tamdeem.ui.payment.scan

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityManualBinding
import com.voxel.tamdeem.databinding.ActivityScanBinding
import com.voxel.tamdeem.ui.wallet.WalletActivity

class ScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }

    private fun handleClick() {
        binding.imgScan.setOnClickListener {
            val intent = Intent(this@ScanActivity, WalletActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}