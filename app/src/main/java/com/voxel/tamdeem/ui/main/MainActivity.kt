package com.voxel.tamdeem.ui.main

import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.voxel.bookmeapp.ui.home.model.Cat
import com.voxel.tamdeem.R
import com.voxel.tamdeem.databinding.ActivityMainBinding
import com.voxel.tamdeem.ui.login.LoginActivity
import com.voxel.tamdeem.ui.main.adapter.HomeHistoryAdapter
import com.voxel.tamdeem.ui.main.adapter.SliderAdapter
import com.voxel.tamdeem.ui.main.adapter.SliderHomeAdapter
import com.voxel.tamdeem.ui.world.WorldActivity

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
        manageViewPager()
        manageHistory()
        handleClick()
    }

    private fun handleClick() {
        binding.cardSelectWord.setOnClickListener {
            val intent = Intent(this@MainActivity, WorldActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        binding.imgProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }

    private fun manageHistory() {
        binding.recyclerHistory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val historyAdapter = HomeHistoryAdapter(this@MainActivity, createArtistList()) { Cat, position ->

            }
            adapter = historyAdapter
        }
    }

    private fun manageViewPager() {

        val demoData = arrayListOf(
            "Curabitur sit amet rutrum enim, sit amet commodo urna. Nullam nec nisl eget purus vulputate ultrices nec sit amet est. Sed sodales maximus risus sit amet placerat.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus sit amet lectus a mi lobortis iaculis. Mauris odio tortor, accumsan vel gravida sit amet, malesuada a tortor.",
            "Praesent efficitur eleifend eros quis elementum. Vivamus eget nunc ante. Sed sed sodales libero. Nam ipsum lorem, consequat at ipsum sit amet, tempor vulputate nibh.",
            "Aliquam sodales imperdiet augue at consectetur. Suspendisse dui mauris, tincidunt non auctor quis, facilisis et tellus.",
            "Ut non tincidunt neque, et sodales ligula. Quisque interdum in dui sit amet sagittis. Curabitur erat magna, maximus quis libero quis, dapibus eleifend orci."
        )

        binding.homeSlide.adapter = SliderHomeAdapter(demoData)
        binding.homeSlide.setCurrentItem(1, false)
        binding.homeSlide.offscreenPageLimit = 3
        binding.homeSlide.clipToPadding = false
        binding.homeSlide.clipChildren = false
        binding.homeSlide.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((13 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        binding.homeSlide.setPageTransformer(compositePageTransformer)
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
