package com.example.assignment2

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class Game : AppCompatActivity() {

    private lateinit var hungerBar: ProgressBar
    private lateinit var happyBar: ProgressBar
    private lateinit var cleanBar: ProgressBar

    var hungerProgress = 0
    var cleanProgress = 0
    var happyProgress = 0

    private val handler = Handler()
    private val progressUpdater = object : Runnable {
        override fun run() {
            // Decrease progress by 5 if progress is greater than 0
            hungerProgress = (hungerProgress - 5).coerceAtLeast(0)
            cleanProgress = (cleanProgress - 5).coerceAtLeast(0)
            happyProgress = (happyProgress - 5).coerceAtLeast(0)

            // Update progress bars
            hungerBar.progress = hungerProgress
            cleanBar.progress = cleanProgress
            happyBar.progress = happyProgress

            // Schedule the next update after 1 minute
            handler.postDelayed(this, 60000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        hungerBar = findViewById(R.id.hungerBar)
        cleanBar = findViewById(R.id.cleanBar)
        happyBar = findViewById(R.id.happyBar)

        val image = findViewById<ImageView>(R.id.imageView)
        val feed = findViewById<Button>(R.id.feed)
        val clean = findViewById<Button>(R.id.clean)
        val play = findViewById<Button>(R.id.plays)

        // Start updating progress bars every minute
        handler.post(progressUpdater)

        feed.setOnClickListener {
            test(image, R.drawable.food)
            if (hungerProgress < 100) {
                hungerProgress = (hungerProgress + 5).coerceAtMost(100)
                hungerBar.progress = hungerProgress
            }
            if (hungerProgress == 100) {
                feed.isEnabled = false
                Toast.makeText(this, "Bob is full", Toast.LENGTH_SHORT).show()
            }
        }

        clean.setOnClickListener {
            test(image, R.drawable.wash)
            if (cleanProgress < 100) {
                cleanProgress = (cleanProgress + 5).coerceAtMost(100)
                cleanBar.progress = cleanProgress
            }
            if (cleanProgress == 100) {
                clean.isEnabled = false
                Toast.makeText(this, "Bob is Clean", Toast.LENGTH_SHORT).show()
            }
        }

        play.setOnClickListener {
            test(image, R.drawable.play)
            if (happyProgress < 100) {
                happyProgress = (happyProgress + 5).coerceAtMost(100)
                happyBar.progress = happyProgress
            }
            if (happyProgress == 100) {
                play.isEnabled = false
                Toast.makeText(this, "Bob is Happy", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun test(imageView: ImageView, drawableId: Int) {
        imageView.setImageResource(drawableId)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove pending updates when activity is destroyed
        handler.removeCallbacks(progressUpdater)
    }
}
