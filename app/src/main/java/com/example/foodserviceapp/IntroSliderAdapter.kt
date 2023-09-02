package com.example.foodserviceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IntroSliderAdapter(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<IntroSliderAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val logo = view.findViewById<ImageView>(R.id.logo)
        private val companyName = view.findViewById<TextView>(R.id.companyName)
        private val image = view.findViewById<ImageView>(R.id.image)
        private val description = view.findViewById<TextView>(R.id.title)
        private val title = view.findViewById<TextView>(R.id.description)

        fun bind(introSlide: IntroSlide) {

            logo.setImageResource(introSlide.logo)
            companyName.text = introSlide.companyName
            image.setImageResource(introSlide.image)
            description.text = introSlide.description
            title.text = introSlide.title
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutResId = if (viewType == 0) {
            R.layout.intro_screen_activity // Use the first layout for the first slide
        } else if (viewType == 1) {
            R.layout.second_fragment // Use the layout for the second slide
        } else {
            R.layout.third_fragment
        }
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    override fun getItemViewType(position: Int): Int {
        // Return different view types for different slides (0 for the first, 1 for the second, and so on)
        return position
    }
}