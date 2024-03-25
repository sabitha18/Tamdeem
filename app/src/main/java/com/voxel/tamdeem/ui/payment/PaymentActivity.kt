package com.voxel.tamdeem.ui.payment

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityPaymentBinding
import com.voxel.tamdeem.databinding.ActivityWorldListingBinding
import com.voxel.tamdeem.ui.login.LoginActivity
import com.voxel.tamdeem.ui.payment.manual.ManualActivity
import com.voxel.tamdeem.ui.payment.scan.ScanActivity

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClick()
    }

    private fun handleClick() {

        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@PaymentActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        binding.cardPay.setOnClickListener {
            val intent = Intent(this@PaymentActivity, ManualActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}