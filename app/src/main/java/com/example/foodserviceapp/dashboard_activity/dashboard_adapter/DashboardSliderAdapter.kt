package com.example.foodserviceapp.dashboard_activity.dashboard_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodserviceapp.R
import com.example.foodserviceapp.dashboard_activity.dashboard_dataclass.DashboardSlideDataClass


class DashboardSliderAdapter(private val dashboardSlides: List<DashboardSlideDataClass>) :
    RecyclerView.Adapter<DashboardSliderAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image = view.findViewById<ImageView>(R.id.dashboardImage)
        private val image2= view.findViewById<ImageView>(R.id.dashboardImage2)

        fun bind(dashboardSlide: DashboardSlideDataClass) {

            image.setImageResource(dashboardSlide.image)
           /* image2.setImageResource(dashboardSlide.image2)*/


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dashboard_indicator_box, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dashboardSlides.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dashboardSlides[position])
    }

    override fun getItemViewType(position: Int): Int {
        // Return different view types for different slides (0 for the first, 1 for the second, and so on)
        return position
    }
}