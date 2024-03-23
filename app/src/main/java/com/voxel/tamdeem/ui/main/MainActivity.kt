package com.voxel.tamdeem.ui.main

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityMainBinding
import com.voxel.tamdeem.ui.main.adapter.SliderAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val autoSlideDelay = 5000
    private var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageSlider()
    }

    private fun manageSlider() {
        sliderAdapter = SliderAdapter(itemCount = 5) // Change itemCount as needed

        binding.viewPager.adapter = sliderAdapter

        handler = Handler()
        runnable = Runnable {
            if (currentPage == sliderAdapter.itemCount) {
                currentPage = 0
            }
            binding.viewPager.setCurrentItem(currentPage++, true)
            handler.postDelayed(runnable, autoSlideDelay.toLong())
        }
        handler.postDelayed(runnable, autoSlideDelay.toLong())
    }
}
