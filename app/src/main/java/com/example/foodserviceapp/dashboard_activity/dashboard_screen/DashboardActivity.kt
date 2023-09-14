package com.example.foodserviceapp.dashboard_activity.dashboard_screen

import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.foodserviceapp.R
import com.example.foodserviceapp.dashboard_activity.dashboard_adapter.DashboardSliderAdapter
import com.example.foodserviceapp.dashboard_activity.dashboard_adapter.DashboardSliderAdapter2
import com.example.foodserviceapp.dashboard_activity.dashboard_adapter.DashboardSliderAdapter3
import com.example.foodserviceapp.dashboard_activity.dashboard_adapter.DashboardSliderAdapter4
import com.example.foodserviceapp.dashboard_activity.dashboard_dataclass.DashboardSlideDataClass
import com.example.foodserviceapp.dashboard_activity.dashboard_dataclass.DashboardSlideDataClass2
import com.example.foodserviceapp.dashboard_activity.dashboard_dataclass.DashboardSlideDataClass3
import com.example.foodserviceapp.dashboard_activity.dashboard_dataclass.DashboardSlideDataClass4
import com.example.foodserviceapp.dashboard_activity.dashboard_fragment.HomeFragment
import com.example.foodserviceapp.dashboard_activity.dashboard_fragment.OrderFragment
import com.example.foodserviceapp.dashboard_activity.dashboard_fragment.ProfileFragment
import com.example.foodserviceapp.dashboard_activity.dashboard_fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


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

    private val dashboardSliderAdapter4 = DashboardSliderAdapter4(
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

        dashboardViewPager3.registerOnPageChangeCallback(object :
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

        dashboardViewPager4.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position, dashboardIndicatorContainer4)
            }
        })


        setUpFragment()



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

    private fun setUpFragment(){

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val orderFragment = OrderFragment()
        val profileFragment = ProfileFragment()

        val bottomNavigationBar = findViewById<BottomNavigationView>(R.id.bottomNavigationBar)

        /*setCurrentFragment(homeFragment)*/

        bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.search -> setCurrentFragment(searchFragment)
                R.id.orders-> setCurrentFragment(orderFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }


    }
