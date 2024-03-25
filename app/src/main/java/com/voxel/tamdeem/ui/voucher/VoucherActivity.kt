package com.voxel.tamdeem.ui.voucher

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityMainBinding
import com.voxel.tamdeem.databinding.ActivityVoucherBinding
import com.voxel.tamdeem.ui.login.LoginActivity
import com.voxel.tamdeem.ui.main.adapter.HomeHistoryAdapter
import com.voxel.tamdeem.ui.payment.scan.ScanActivity
import com.voxel.tamdeem.ui.voucher.adapter.VoucherAdapter

class VoucherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVoucherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityVoucherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageVoucher()
        handleClick()
    }
    private fun handleClick() {
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@VoucherActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

    }
    private fun manageVoucher() {
        binding.recyclerVoucher.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val historyAdapter = VoucherAdapter(this@VoucherActivity, createArtistList()) { Cat, position ->

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