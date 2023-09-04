package com.example.foodserviceapp.intro_screen

import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.foodserviceapp.R

open class IntroScreenActivity : AppCompatActivity() {

    lateinit var indicatorContainer: LinearLayout

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlideDataClass(

                R.drawable.pic1,
                "Tamang FoodService",
                R.drawable.pic2,
                "All your favorites",
                "Order from the best local restaurants with easy on demand delivery"
            ),
            IntroSlideDataClass(

                R.drawable.pic1,
                "Tamang FoodService",
                R.drawable.pic3,
                "Free delivery offers",
                "Free delivery for new customers via Apple Pay and others payment methods."

            ),
            IntroSlideDataClass(

                R.drawable.pic1,
                "Tamang FoodService",
                R.drawable.pic4,
                "Choose your food",
                "Easily find your type of food craving and you'll get delivery in wide range."
            ),
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.indecator_box)
        val introViewPager = findViewById<ViewPager2>(R.id.viewPager)
        introViewPager.adapter = introSliderAdapter

        indicatorContainer = findViewById(R.id.indicatorContainer)

        setUpIndicator()
        setCurrentIndicator(0)
      introViewPager.registerOnPageChangeCallback(object :
      ViewPager2.OnPageChangeCallback() {

          override fun onPageSelected(position: Int) {
              super.onPageSelected(position)
              setCurrentIndicator(position)
          }
      })

    }

    private fun setUpIndicator() {
        val indicator = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicator.indices){
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.inactive_indicator
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorContainer.addView(indicator[i])

        }
    }

    private fun setCurrentIndicator(index:Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageview = indicatorContainer.get(i) as ImageView
        if (i == index){
            imageview.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.active_indicator
                )
            )
        }else{
            imageview.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.inactive_indicator
                )
            )
        }
        }
    }


}