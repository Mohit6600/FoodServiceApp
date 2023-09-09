package com.example.foodserviceapp.dashboard_screen

import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.foodserviceapp.R


open class DashboardActivity : AppCompatActivity() {

    lateinit var dashboardIndicatorContainer: LinearLayout
    lateinit var dashboardIndicatorContainer2: LinearLayout

    private val dashboardSliderAdapter = DashboardSliderAdapter(
        listOf(
            DashboardSlideDataClass(

                R.drawable.dashboardpic,
                /*R.drawable.dashboardpic6*/
            ),
            DashboardSlideDataClass(

                R.drawable.dashboardpic,
        /*        R.drawable.dashboardpic6*/

            ),
            DashboardSlideDataClass(

                R.drawable.pic1,
         /*       R.drawable.dashboardpic6*/
            ),
        )

    )

    private val dashboardSliderAdapter2 = DashboardSliderAdapter2(
        listOf(
            DashboardSlideDataClass2(


                R.drawable.dashboardpic6
            ),
            DashboardSlideDataClass2(


                        R.drawable.dashboardpic6

            ),
            DashboardSlideDataClass2(


                       R.drawable.dashboardpic6
            ),
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        // this is for first view pager in dashboard
        val dashboardViewPager = findViewById<ViewPager2>(R.id.viewPager2)
             dashboardViewPager.adapter = dashboardSliderAdapter

        dashboardIndicatorContainer = findViewById(R.id.dashboardIndicatorContainer)


        setUpIndicator(dashboardIndicatorContainer)
        setCurrentIndicator(0,dashboardIndicatorContainer)

        dashboardViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer)
            }
        })


        // this is for first view pager in dashboard
        val dashboardViewPager2 = findViewById<ViewPager2>(R.id.viewPager3)
        dashboardViewPager2.adapter = dashboardSliderAdapter2
        dashboardIndicatorContainer2 = findViewById(R.id.dashboardIndicatorContainer2)

        setUpIndicator(dashboardIndicatorContainer2)
        setCurrentIndicator(0,dashboardIndicatorContainer2)

        dashboardViewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer2)
            }
        })

    }

    private fun setUpIndicator(dashboardIndicatorContainer: LinearLayout) {
        val indicator = arrayOfNulls<ImageView>(dashboardSliderAdapter.itemCount)
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
            dashboardIndicatorContainer.addView(indicator[i])
            /*dashboardIndicatorContainer2.addView(indicator[i])*/

        }
    }

    private fun setCurrentIndicator(index: Int, dashboardIndicatorContainer: LinearLayout){
        val childCount = dashboardIndicatorContainer.childCount
        for (i in 0 until childCount){
            val imageview = dashboardIndicatorContainer.get(i) as ImageView

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

  /*      val childCount2 = dashboardIndicatorContainer2.childCount
        for (i in 0 until childCount2){
            val imageview2 = dashboardIndicatorContainer2.get(i) as ImageView

            if (i == index){
                imageview2.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.active_indicator
                    )
                )
            }else{
                imageview2.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.inactive_indicator
                    )
                )
            }
        }*/

    }


}