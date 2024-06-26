package com.voxel.tamdeem.ui.login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityLoginBinding
import com.voxel.tamdeem.ui.account.AccountActivity
import com.voxel.tamdeem.ui.payment.scan.ScanActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handleClick()
    }

    private fun handleClick() {
        binding.cardLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, AccountActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}