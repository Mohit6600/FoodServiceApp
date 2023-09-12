package com.example.foodserviceapp.dashboard_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodserviceapp.R


class DashboardSliderAdapter3(private val dashboardSlides: List<DashboardSlideDataClass3>) :
    RecyclerView.Adapter<DashboardSliderAdapter3.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*private val image = view.findViewById<ImageView>(R.id.dashboardImage)*/
        private val image= view.findViewById<ImageView>(R.id.dashboardImage3)

        fun bind(dashboardSlide: DashboardSlideDataClass3) {

            /*image.setImageResource(dashboardSlide.image)*/
            image.setImageResource(dashboardSlide.image)


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