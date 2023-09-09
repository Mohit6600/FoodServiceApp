package com.example.foodserviceapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CurrentLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.current_locatation_activtiy)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextVIew)

        var suggestions = arrayOf(
            "sector-15.Pkl",
            "sector-16.Pkl",
            "sector-11.Pkl",
            "sector-10.Pkl",
            "sector-12.Pkl"
        )

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,suggestions)
        autoCompleteTextView.threshold = 0
        autoCompleteTextView.setAdapter(adapter)


    }
}