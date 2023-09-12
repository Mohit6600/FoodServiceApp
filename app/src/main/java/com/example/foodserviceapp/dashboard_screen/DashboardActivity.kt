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
    lateinit var dashboardIndicatorContainer3: LinearLayout
    lateinit var dashboardIndicatorContainer4: LinearLayout

    private val dashboardSliderAdapter = DashboardSliderAdapter(
        listOf(
            DashboardSlideDataClass(

                R.drawable.dashboardpic,
            ),
            DashboardSlideDataClass(

                R.drawable.dashboardpic,

            ),
            DashboardSlideDataClass(

                R.drawable.pic1,
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



    private val dashboardSliderAdapter3 = DashboardSliderAdapter3(
        listOf(
            DashboardSlideDataClass3(


                R.drawable.dashboardpic7
            ),
            DashboardSlideDataClass3(


                R.drawable.dashboardpic7

            ),
            DashboardSlideDataClass3(


                R.drawable.dashboardpic7
            ),
        )

    )

    private val dashboardSliderAdapter4= DashboardSliderAdapter4(
        listOf(
            DashboardSlideDataClass4(


                R.drawable.dashboardpic8
            ),
            DashboardSlideDataClass4(


                R.drawable.dashboardpic8

            ),
            DashboardSlideDataClass4(


                R.drawable.dashboardpic8
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
        setCurrentIndicator(0, dashboardIndicatorContainer)

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
        setCurrentIndicator(0, dashboardIndicatorContainer2)

        dashboardViewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer2)
            }
        })


        val dashboardViewPager3 = findViewById<ViewPager2>(R.id.viewPager4)
        dashboardViewPager3.adapter = dashboardSliderAdapter3
        dashboardIndicatorContainer3 = findViewById(R.id.dashboardIndicatorContainer3)

        setUpIndicator(dashboardIndicatorContainer3)
        setCurrentIndicator(0, dashboardIndicatorContainer3)

        dashboardViewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer3)
            }
        })

        val dashboardViewPager4 = findViewById<ViewPager2>(R.id.viewPager5)
        dashboardViewPager4.adapter = dashboardSliderAdapter4
        dashboardIndicatorContainer4 = findViewById(R.id.dashboardIndicatorContainer4)

        setUpIndicator(dashboardIndicatorContainer4)
        setCurrentIndicator(0, dashboardIndicatorContainer4)

        dashboardViewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer4)
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
        for (i in indicator.indices) {
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

    private fun setCurrentIndicator(index: Int, dashboardIndicatorContainer: LinearLayout) {
        val childCount = dashboardIndicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageview = dashboardIndicatorContainer.get(i) as ImageView

            if (i == index) {
                imageview.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.active_indicator
                    )
                )
            } else {
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