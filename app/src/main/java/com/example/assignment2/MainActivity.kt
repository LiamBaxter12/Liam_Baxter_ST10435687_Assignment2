package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //code out here
        val Button1= findViewById<Button>(R.id.Button1)
        Button1.setOnClickListener {

            // create the explicit intent
            val intent = Intent(this, Game::class.java)

            // start your next activity
            startActivity(intent)
    }
}}